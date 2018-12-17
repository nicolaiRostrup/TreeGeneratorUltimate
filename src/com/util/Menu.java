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
            System.out.println("What kind of trunk design, would you like? (S)lim, (N)ormal or (W)ide?");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("s")) {
                treeDesign.setInitialWidth(30f);
                treeDesign.setMaxTrunkSections(4);
                treeDesign.setBigBranchProbability(3);
                break;
            }
            if (answer.equalsIgnoreCase("n")) {
                treeDesign.setInitialWidth(50f);
                treeDesign.setMaxTrunkSections(4);
                treeDesign.setBigBranchProbability(5);
                break;
            }
            if (answer.equalsIgnoreCase("w")) {
                treeDesign.setInitialWidth(100f);
                treeDesign.setMaxTrunkSections(3);
                treeDesign.setBigBranchProbability(6);
                break;
            }
        }

        while (true) {

            System.out.println("Please choose next preferred tree feature:");
            System.out.println("What shape should the crown be? (T)all? (S)hort? (W)ide?");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("t")) {
                treeDesign.setStretchTopBranches(true);
                treeDesign.setBranchLengthLow(50f);
                treeDesign.setBranchLengthHigh(80f);
                treeDesign.setTrunkHeight(275f);
                treeDesign.setBranchNumberHigh(3);
                treeDesign.setTrimLimitAngle(0.1f);
                treeDesign.setMinBranchThickness(0.2f);
                break;
            }
            if (answer.equalsIgnoreCase("s")) {
                treeDesign.setStretchTopBranches(false);
                treeDesign.setBranchLengthLow(30f);
                treeDesign.setBranchLengthHigh(60f);
                treeDesign.setTrunkHeight(200f);
                treeDesign.setBranchNumberHigh(4);
                treeDesign.setTrimLimitAngle(0);
                treeDesign.setMinBranchThickness(0.5f);
                break;
            }
            if (answer.equalsIgnoreCase("w")) {
                treeDesign.setStretchTopBranches(false);
                treeDesign.setBranchLengthLow(60f);
                treeDesign.setBranchLengthHigh(100f);
                treeDesign.setTrunkHeight(230f);
                treeDesign.setBranchNumberHigh(4);
                treeDesign.setTrimLimitAngle(0.9f);
                treeDesign.setMinBranchThickness(0.4f);
                break;
            }
        }

        while (true) {

            System.out.println("Please choose next preferred tree feature:");
            System.out.println("What kind of irregularity should the tree possess? (N)one? (M)oderate? (S)trong?");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("n")) {
                treeDesign.setRelativeRotation(0);
                break;
            }
            if (answer.equalsIgnoreCase("m")) {
                treeDesign.setRelativeRotation(0.4f);
                break;
            }
            if (answer.equalsIgnoreCase("s")) {
                treeDesign.setRelativeRotation(1f);
                break;
            }
        }

        while (true) {

            System.out.println("Please choose next preferred tree feature:");
            System.out.println("What color should the trunk and branches have? (D)ark brown? (G)reen? (L)ight grey?");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("d")) {
                treeDesign.setColorOfBark(new int[]{50, 21, 6});
                break;
            }
            if (answer.equalsIgnoreCase("g")) {
                treeDesign.setColorOfBark(new int[]{0,65,0});
                break;
            }
            if (answer.equalsIgnoreCase("l")) {
                treeDesign.setColorOfBark(new int[]{169, 179, 168});
                break;
            }
        }

        while (true) {

            System.out.println("And, finally, please choose last tree feature:");
            System.out.println("What color should the leaves have? (D)ark green? (L)ight green? (O)range or (N)o leaves");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("d")) {
                treeDesign.setColorOfLeaves(new int[]{7, 38, 4,26,77,15,30,133,6});
                break;
            }
            if (answer.equalsIgnoreCase("l")) {
                treeDesign.setColorOfLeaves(new int[]{9, 80, 1,25,120,5, 39,194,1});
                break;
            }

            if (answer.equalsIgnoreCase("o")) {
                treeDesign.setColorOfLeaves(new int[]{79, 29, 5,138,0,32, 255,143,35});
                break;
            }
            if (answer.equalsIgnoreCase("n")) {
                treeDesign.setSkipLeaves(true);
                break;
            }
        }

        System.out.print("Press enter to begin tree generation.");
        sc.nextLine();


    }

}

