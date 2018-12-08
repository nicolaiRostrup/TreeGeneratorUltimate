package com.util;

import com.components.*;
import com.enums.BranchType;
import com.lists.TreeComponentList;
import processing.core.PApplet;



public class TreeGenerator {

    private PApplet p;
    private TreeComponentList allTreeComponents = new TreeComponentList();


    public TreeGenerator(PApplet p) {

        this.p = p;

    }


    public void createTrunk() {

        Trunk trunk = new Trunk(p);
        trunk.hasOpenEnd = true;

        allTreeComponents.insertFromTail(trunk);

        trunk.coordList.insertFromTail(new Coordinate(p.width / 2f, 0));
        trunk.coordList.insertFromTail(new Coordinate(p.width / 2f, p.height * Menu.getSizeFactor()));

        trunk.growAngle = AdditionalTools.getAngleFromVector(
                trunk.coordList.getHead().getC().getX(),
                trunk.coordList.getHead().getC().getY(),
                trunk.coordList.getTail().getC().getX(),
                trunk.coordList.getTail().getC().getY());

    }

//    void createBranches() {
//
//        do {
//
//            TreeComponent openEnd = allTreeComponents.nextOpenEnd();
//
//            int branchNumber = (int) p.random(Menu.branchNumberLow, Menu.branchNumberHigh);
//
//            float totalAngle = 2 * Menu.crownWidthFactor * branchNumber;
//            float incrementAngle = totalAngle / (branchNumber - 1);
//            float theta = openEnd.growAngle - totalAngle / 2f;
//
//            if (theta < 0) {
//                theta = 0;
//            }
//
//            for (int j = 0; j < branchNumber; j++) {
//
//                float branchLength = p.random(Menu.branchLengthLow, Menu.branchLengthHigh);
//
//                processTreeComponent(new Branch(p), openEnd, branchLength, theta);
//
//                theta = theta + incrementAngle;
//                if (theta > p.PI) {
//                    theta = p.PI;
//                }
//
//            }
//            openEnd.hasOpenEnd = false;
//
//        } while (allTreeComponents.openEndCount() > 0 && allTreeComponents.length() < 25);
//
//
//    }

    public void createBranches() {

        processBranching(BranchType.BRANCH, 25);
    }

    public void createSmallBranches(){

        processBranching(BranchType.SMALLBRANCH, 110);
    }

    public void createTwigs(){

        processBranching(BranchType.TWIG, 500);
    }


    private void processBranching(BranchType branchType, int maxTreeComponents) {
        do {

            TreeComponent openEnd = allTreeComponents.nextOpenEnd();

            int branchNumber = (int) p.random(Menu.getBranchNumberLow(), Menu.getBranchNumberHigh());

            float totalAngle = 2 * Menu.getCrownWidthFactor() * branchNumber;
            float incrementAngle = totalAngle / (branchNumber - 1);
            float theta = openEnd.growAngle - totalAngle / 2f;

            if (theta < 0) {
                theta = 0;
            }

            for (int j = 0; j < branchNumber; j++) {

                float branchLength = p.random(Menu.getBranchLengthLow(), Menu.getBranchLengthHigh());

                TreeComponent t = new BranchObject(p, branchType).returnMe();

                processTreeComponent(t, openEnd, branchLength, theta);

                theta = theta + incrementAngle;
                if (theta > p.PI) {
                    theta = p.PI;
                }

            }
            openEnd.hasOpenEnd = false;

        } while (allTreeComponents.openEndCount() > 0 && allTreeComponents.length() < maxTreeComponents);
    }


//    void createSmallBranches() {
//
//        do {
//
//            TreeComponent openEnd = allTreeComponents.nextOpenEnd();
//
//            int smallBranchNumber = (int) p.random(Menu.branchNumberLow, Menu.branchNumberHigh);
//
//            float totalAngle = 2 * Menu.crownWidthFactor * smallBranchNumber;
//            float incrementAngle = totalAngle / (smallBranchNumber - 1);
//            float theta = openEnd.growAngle - totalAngle / 2f;
//
//            if (theta < 0) {
//                theta = 0;
//            }
//
//            for (int j = 0; j < smallBranchNumber; j++) {
//
//                float smallBranchLength = p.random(Menu.branchLengthLow, Menu.branchLengthHigh);
//
//                if (theta < 3 * p.PI / 4 && theta > p.PI / 4) {
//                    smallBranchLength = smallBranchLength + 50;
//                } else {
//                    smallBranchLength = smallBranchLength - 50;
//                }
//
//                processTreeComponent(new SmallBranch(p), openEnd, smallBranchLength, theta);
//
//                theta = theta + incrementAngle;
//
//                if (theta > p.PI) {
//                    theta = p.PI;
//                }
//
//            }
//            openEnd.hasOpenEnd = false;
//
//        } while (allTreeComponents.openEndCount() > 0 && allTreeComponents.length() < 110);
//
//
//    }


//    void createTwigs() {
//
//
//        do {
//
//            TreeComponent openEnd = allTreeComponents.nextOpenEnd();
//
//            int twigNumber = (int) p.random(Menu.branchNumberLow, Menu.branchNumberHigh);
//
//            float totalAngle = 2 * Menu.crownWidthFactor * twigNumber;
//            float incrementAngle = totalAngle / (twigNumber - 1);
//            float theta = openEnd.growAngle - totalAngle / 2f;
//
//            if (theta < -0.3f) {
//                theta = -0.3f;
//            }
//
//            for (int j = 0; j < twigNumber; j++) {
//
//                float twigLength = p.random(Menu.branchLengthLow, Menu.branchLengthHigh);
//
//                if (theta < 3 * p.PI / 4 && theta > p.PI / 4) {
//                    twigLength = twigLength + 30;
//                } else {
//                    twigLength = twigLength - 30;
//                }
//
//                processTreeComponent(new Twig(p), openEnd, twigLength, theta);
//
//                theta = theta + incrementAngle;
//
//                if (theta > p.PI + 0.3f) {
//                    theta = p.PI + 0.3f;
//                }
//
//            }
//            openEnd.hasOpenEnd = false;
//
//        } while (allTreeComponents.openEndCount() > 0 && allTreeComponents.length() < 500);
//
//    }


    public void createLeaves() {

        do {
            TreeComponent openEnd = allTreeComponents.nextOpenEnd();

            int leafNumber = 5;
            float leafDistance = 15f;

            float totalAngle = 4 * p.PI / 3f;
            float extensionAngle = openEnd.growAngle;
            float theta = extensionAngle - totalAngle / 2f;
            float incrementAngle = totalAngle / (leafNumber - 1);

            LeafGroup l = new LeafGroup(p);

            l.coordList.insertFromHead(openEnd.coordList.getTail().getC());
            l.growAngle = openEnd.growAngle;

            allTreeComponents.insertFromTail(l);

            for (int j = 0; j < leafNumber; j++) {

                Coordinate leafCenter = AdditionalTools.localPolarInput(
                        openEnd.coordList.getTail().getC().getX(),
                        openEnd.coordList.getTail().getC().getY(),
                        leafDistance,
                        theta);

                l.coordList.insertFromTail(leafCenter);

                theta = theta + incrementAngle;

            }
            openEnd.hasOpenEnd = false;

        } while (allTreeComponents.openEndCount() > 0);


    }

    private void processTreeComponent(TreeComponent t, TreeComponent openEnd, float branchLength, float theta) {
        t.coordList.insertFromHead(openEnd.coordList.getTail().getC());

        Coordinate extensionCoordinate = AdditionalTools.localPolarInput(
                openEnd.coordList.getTail().getC().getX(),
                openEnd.coordList.getTail().getC().getY(),
                branchLength,
                theta);

        t.coordList.insertFromTail(extensionCoordinate);
        t.hasOpenEnd = true;
        t.growAngle = theta;
        allTreeComponents.insertFromTail(t);

    }

    public void makeTreeIrregular() {

        for (int i = 1; i <= allTreeComponents.length(); i++) {

            allTreeComponents.getTreeComponentAt(i).makeIrregular();
        }

    }


    public void shadeDrawing() {

        for (int i = 1; i <= allTreeComponents.length(); i++) {

            allTreeComponents.getTreeComponentAt(i).generateShading();

        }
    }


}