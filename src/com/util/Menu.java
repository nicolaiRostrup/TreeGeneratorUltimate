package com.util;


import java.util.Scanner;


public class Menu {


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

        TreeDesign treeDesign = TreeDesign.getInstance();

        while (true) {

            System.out.println("Please choose your preferred tree features:");
            System.out.println("What overall tree size would you like? (S)mall? (M)edium? (L)arge?");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("s")) {
                //treeDesign.size = ;
                break;
            }
            if (answer.equalsIgnoreCase("m")) {

                break;
            }
            if (answer.equalsIgnoreCase("l")) {

                break;
            }
        }

        while (true) {

            System.out.println("Please choose next preferred tree feature:");
            System.out.println("What shape should the crown be? (T)all? (S)hort? (W)ide?");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("t")) {

                break;
            }
            if (answer.equalsIgnoreCase("s")) {

                break;
            }
            if (answer.equalsIgnoreCase("w")) {

                break;
            }
        }

        while (true) {

            System.out.println("Please choose next preferred tree feature:");
            System.out.println("What kind of irregularity should the tree possess? (N)one? (M)oderate? (S)trong?");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("n")) {

                break;
            }
            if (answer.equalsIgnoreCase("m")) {

                break;
            }
            if (answer.equalsIgnoreCase("s")) {

                break;
            }
        }

        while (true) {

            System.out.println("Please choose next preferred tree feature:");
            System.out.println("What color should the trunk and branches have? (D)ark brown? (G)reen? (L)ight grey?");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("d")) {

                break;
            }
            if (answer.equalsIgnoreCase("g")) {

                break;
            }
            if (answer.equalsIgnoreCase("l")) {

                break;
            }
        }

        while (true) {

            System.out.println("And, finally, please choose last tree feature:");
            System.out.println("What color should the leaves have? (D)ark green? (L)ight green? (O)range or (R)ed?");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("d")) {

                break;
            }
            if (answer.equalsIgnoreCase("l")) {

                break;
            }
            if (answer.equalsIgnoreCase("o")) {

                break;
            }
            if (answer.equalsIgnoreCase("r")) {

                break;
            }
        }

        System.out.print("Press enter to begin tree generation.");
        sc.nextLine();


    }
//
//    public void processUserPreferences() {
////
//
//       TreeSize
//        if (treeSize == TreeSize.SMALL) {
//            sizeFactor = 0.25f;
//        }
//        if (treeSize == TreeSize.MEDIUM) {
//            sizeFactor = 0.4f;
//        }
//        if (treeSize == TreeSize.LARGE) {
//            sizeFactor = 0.55f;
//        }
//        //CrownShape
//        if (crownShape == CrownShape.TALL) {
//            crownWidthFactor = 0.25f;
//            crownHeightFactor = 1f;
//            branchLengthLow = 100;
//            branchLengthHigh = 120;
//        }
//        if (crownShape == CrownShape.SHORT) {
//            crownWidthFactor = 0.25f;
//            crownHeightFactor = 0.25f;
//            branchLengthLow = 50;
//            branchLengthHigh = 75;
//        }
//        if (crownShape == CrownShape.WIDE) {
//            crownWidthFactor = 1.25f;
//            crownHeightFactor = 0.3f; //
//            branchLengthLow = 100;
//            branchLengthHigh = 120;
//        }
//        //Irregularity
//        if (irregularity == Irregularity.NONE) {
//            randomRadiusFactor = 0;
//            branchNumberLow = 2;
//            branchNumberHigh = 2;
//            branchLengthHigh = (branchLengthHigh + branchLengthLow) / 2;
//        }
//        if (irregularity == Irregularity.MODERATE) {
//            randomRadiusFactor = 4f;
//            branchNumberLow = 2;
//            branchNumberHigh = 4;
//        }
//        if (irregularity == Irregularity.STRONG) {
//            randomRadiusFactor = 10f;
//            branchNumberLow = 1;
//            branchNumberHigh = 5;
//        }
//
//        //BarkColor
//        if (barkColor == BarkColor.DARKBROWN) {
//            colorOfBark = new int[]{50,21,6};
//        }
//        if (barkColor == BarkColor.GREEN) {
//            colorOfBark = new int[]{0,65,0};
//        }
//        if (barkColor == BarkColor.LIGHTGREY) {
//            colorOfBark = new int[]{169, 179, 168};
//        }
//
//        //LeafColor
//        if (leafColor == LeafColor.DARKGREEN) {
//            colorOfLeaves = new int[]{0, 51, 0};
//        }
//        if (leafColor == LeafColor.LIGHTGREEN) {
//            colorOfLeaves = new int[]{39, 194, 1};
//        }
//        if (leafColor == LeafColor.ORANGE) {
//            colorOfLeaves = new int[]{247, 134, 9};
//        }
//        if (leafColor == LeafColor.RED) {
//            colorOfLeaves = new int[]{216, 51, 10};
//        }
//
//
//    }
}

