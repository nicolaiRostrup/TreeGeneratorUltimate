package com.util;

import com.enums.*;
import java.util.Scanner;


public class Menu {



    public static float getSizeFactor() {
        return sizeFactor;
    }

    public static float getCrownWidthFactor() {
        return crownWidthFactor;
    }

    public static float getCrownHeightFactor() {
        return crownHeightFactor;
    }

    public static float getRandomRadiusFactor() {
        return randomRadiusFactor;
    }

    public static int getBranchNumberLow() {
        return branchNumberLow;
    }

    public static int getBranchNumberHigh() {
        return branchNumberHigh;
    }

    public static float getBranchLengthLow() {
        return branchLengthLow;
    }

    public static float getBranchLengthHigh() {
        return branchLengthHigh;
    }

    public static int[] getColorOfBark() {
        return colorOfBark;
    }

    public static int[] getColorOfLeaves() {
        return colorOfLeaves;
    }

    //todo: create full list of key variables
    private static float sizeFactor;
    private static float crownWidthFactor;
    private static float crownHeightFactor;
    private static float randomRadiusFactor;
    private static int branchNumberLow;
    private static int branchNumberHigh;
    private static float branchLengthLow;
    private static float branchLengthHigh;
    private static int[] colorOfBark;
    private static int[] colorOfLeaves;


    private TreeSize treeSize;
    private CrownShape crownShape;
    private Irregularity irregularity;
    private BarkColor barkColor;
    private LeafColor leafColor;

    private Scanner sc = new Scanner(System.in);


    public void welcomeMessage() {

        System.out.println();
        System.out.println("=====================================================================");
        System.out.println("||-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-||");
        System.out.println("||                                                                 ||");
        System.out.println("||                  Welcome to TREE GENERATOR.                     ||");
        System.out.println("||                                                                 ||");
        System.out.println("||          This application will generate a tree drawing          ||");
        System.out.println("||        based on OOP and algorithms with random functions        ||");
        System.out.println("||                                                                 ||");
        System.out.println("||-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-||");
        System.out.println("=====================================================================");
        System.out.println();
    }

    public void gatherTreeDesign() {

        while (true) {

            System.out.println("Please choose your preferred tree features:");
            System.out.println("What overall tree size would you like? (S)mall? (M)edium? (L)arge?");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("s")) {
                treeSize = TreeSize.SMALL;
                break;
            }
            if (answer.equalsIgnoreCase("m")) {
                treeSize = TreeSize.MEDIUM;
                break;
            }
            if (answer.equalsIgnoreCase("l")) {
                treeSize = TreeSize.LARGE;
                break;
            }
        }

        while (true) {

            System.out.println("Please choose next preferred tree feature:");
            System.out.println("What shape should the crown be? (T)all? (S)hort? (W)ide?");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("t")) {
                crownShape = CrownShape.TALL;
                break;
            }
            if (answer.equalsIgnoreCase("s")) {
                crownShape = CrownShape.SHORT;
                break;
            }
            if (answer.equalsIgnoreCase("w")) {
                crownShape = CrownShape.WIDE;
                break;
            }
        }

        while (true) {

            System.out.println("Please choose next preferred tree feature:");
            System.out.println("What kind of irregularity should the tree possess? (N)one? (M)oderate? (S)trong?");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("n")) {
                irregularity = Irregularity.NONE;
                break;
            }
            if (answer.equalsIgnoreCase("m")) {
                irregularity = Irregularity.MODERATE;
                break;
            }
            if (answer.equalsIgnoreCase("s")) {
                irregularity = Irregularity.STRONG;
                break;
            }
        }

        while (true) {

            System.out.println("Please choose next preferred tree feature:");
            System.out.println("What color should the trunk and branches have? (D)ark brown? (G)reen? (L)ight grey?");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("d")) {
                barkColor = BarkColor.DARKBROWN;
                break;
            }
            if (answer.equalsIgnoreCase("g")) {
                barkColor = BarkColor.GREEN;
                break;
            }
            if (answer.equalsIgnoreCase("l")) {
                barkColor = BarkColor.LIGHTGREY;
                break;
            }
        }

        while (true) {

            System.out.println("And, finally, please choose last tree feature:");
            System.out.println("What color should the leaves have? (D)ark green? (L)ight green? (O)range or (R)ed?");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("d")) {
                leafColor = LeafColor.DARKGREEN;
                break;
            }
            if (answer.equalsIgnoreCase("l")) {
                leafColor = LeafColor.LIGHTGREEN;
                break;
            }
            if (answer.equalsIgnoreCase("o")) {
                leafColor = LeafColor.ORANGE;
                break;
            }
            if (answer.equalsIgnoreCase("r")) {
                leafColor = LeafColor.RED;
                break;
            }
        }

        System.out.print("Press enter to begin tree generation.");
        sc.nextLine();
    }

    public void processUserPreferences() {
//todo: combine key variables with received enum values.
        //TreeSize
        if (treeSize == TreeSize.SMALL) {
            sizeFactor = 0.25f;
        }
        if (treeSize == TreeSize.MEDIUM) {
            sizeFactor = 0.4f;
        }
        if (treeSize == TreeSize.LARGE) {
            sizeFactor = 0.55f;
        }
        //CrownShape
        if (crownShape == CrownShape.TALL) {
            crownWidthFactor = 0.25f;
            crownHeightFactor = 1f;
            branchLengthLow = 100;
            branchLengthHigh = 120;
        }
        if (crownShape == CrownShape.SHORT) {
            crownWidthFactor = 0.25f;
            crownHeightFactor = 0.25f;
            branchLengthLow = 50;
            branchLengthHigh = 75;
        }
        if (crownShape == CrownShape.WIDE) {
            crownWidthFactor = 1.25f;
            crownHeightFactor = 0.3f; // todo: how to implement this correctly in tree generator
            branchLengthLow = 100;
            branchLengthHigh = 120;
        }
        //Irregularity
        if (irregularity == Irregularity.NONE) {
            randomRadiusFactor = 0;
            branchNumberLow = 2;
            branchNumberHigh = 2;
            branchLengthHigh = (branchLengthHigh + branchLengthLow) / 2;
        }
        if (irregularity == Irregularity.MODERATE) {
            randomRadiusFactor = 4f;
            branchNumberLow = 2;
            branchNumberHigh = 4;
        }
        if (irregularity == Irregularity.STRONG) {
            randomRadiusFactor = 10f;
            branchNumberLow = 1;
            branchNumberHigh = 5;
        }

        //BarkColor
        if (barkColor == BarkColor.DARKBROWN) {
            colorOfBark = new int[]{50,21,6};
        }
        if (barkColor == BarkColor.GREEN) {
            colorOfBark = new int[]{0,65,0};
        }
        if (barkColor == BarkColor.LIGHTGREY) {
            colorOfBark = new int[]{169, 179, 168};
        }

        //LeafColor
        if (leafColor == LeafColor.DARKGREEN) {
            colorOfLeaves = new int[]{0, 51, 0};
        }
        if (leafColor == LeafColor.LIGHTGREEN) {
            colorOfLeaves = new int[]{39, 194, 1};
        }
        if (leafColor == LeafColor.ORANGE) {
            colorOfLeaves = new int[]{247, 134, 9};
        }
        if (leafColor == LeafColor.RED) {
            colorOfLeaves = new int[]{216, 51, 10};
        }


    }
}

