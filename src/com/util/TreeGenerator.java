package com.util;

import com.components.*;
import com.lists.Tree;
import processing.core.PApplet;


public class TreeGenerator {

    private PApplet p;
    private Tree tree = new Tree();


    public TreeGenerator(PApplet p) {

        this.p = p;

    }

    public void createBaseTrunk() {

        Root root = new Root(p);
        root.topCoordinate = new Coordinate(p.width / 2f, 25f);
        root.rootCoordinate = new Coordinate(p.width / 2f, -10f);
        tree.insertFromTail(root);

        Trunk trunk = new Trunk(p);
        tree.insertFromTail(trunk);

        trunk.hasOpenEnd = true;
        trunk.growAngle = p.PI / 2;
        trunk.endWidth = Menu.getInitialWidth() * 1.2f;
        trunk.rootCoordinate = new Coordinate(p.width / 2f, 0);
        trunk.topCoordinate = AdditionalTools.localPolarInput(
                trunk.rootCoordinate.getX(), trunk.rootCoordinate.getY(),
                Menu.getTrunkHeight() / Menu.getMaxTrunkSections(),
                trunk.growAngle);

    }

    public void createTrunkSections() {

        do {
            Trunk openEnd = tree.getNextOpenTrunk();

            Trunk trunk = new Trunk(p);
            tree.insertFromTail(trunk);

            trunk.hasOpenEnd = true;
            trunk.growAngle = p.PI / 2 + (p.random(Menu.getRelativeRotationMin(), Menu.getRelativeRotationMax()) / 5);
            trunk.endWidth = openEnd.endWidth;
            trunk.rootCoordinate = openEnd.topCoordinate;
            trunk.topCoordinate = AdditionalTools.localPolarInput(
                    trunk.rootCoordinate.getX(), trunk.rootCoordinate.getY(),
                    Menu.getTrunkHeight() / Menu.getMaxTrunkSections(),
                    trunk.growAngle);

            if (createBigBranch()) {
                float theta = (p.random(Menu.getBigBranchAngleLow(), Menu.getBigBranchAngleHigh()));
                createBigBranch(trunk, theta);
            }

            if (createBigBranch()) {
                float theta = (p.random(Menu.getBigBranchAngleLow(), Menu.getBigBranchAngleHigh()));
                theta = p.PI - theta;
                createBigBranch(trunk, theta);
            }

            openEnd.hasOpenEnd = false;

        }
        while (tree.length() <= Menu.getMaxTrunkSections());

    }

    public void createTopTrunk() {

        Trunk openEnd = tree.getNextOpenTrunk();

        Trunk trunk = new Trunk(p);
        tree.insertFromTail(trunk);

        trunk.hasOpenEnd = true;
        trunk.growAngle = p.PI / 2 + p.random(Menu.getRelativeRotationMin(), Menu.getRelativeRotationMax());
        trunk.endWidth = openEnd.endWidth;
        trunk.rootCoordinate = openEnd.topCoordinate;
        trunk.topCoordinate = AdditionalTools.localPolarInput(
                trunk.rootCoordinate.getX(), trunk.rootCoordinate.getY(),
                Menu.getTrunkHeight() / Menu.getMaxTrunkSections(),
                trunk.growAngle);

        openEnd.hasOpenEnd = false;

    }

    private boolean createBigBranch() {

        int r = (int) p.random(1, 3);
        return (r == 2);
    }

    private void createBigBranch(Trunk openEnd, float theta) {

        float branchLength = p.random(Menu.getBranchLengthLow(), Menu.getBranchLengthHigh());

        Branch bigBranch = new Branch(p);
        tree.insertFromTail(bigBranch);

        bigBranch.hasOpenEnd = true;
        bigBranch.growAngle = theta;
        bigBranch.endWidth = (openEnd.endWidth / 3);

        bigBranch.rootCoordinate = openEnd.topCoordinate;
        bigBranch.topCoordinate = AdditionalTools.localPolarInput(
                bigBranch.rootCoordinate.getX(),
                bigBranch.rootCoordinate.getY(),
                branchLength,
                theta);
    }


    public void createBranches() {

        do {

            TreeComponent openEnd = tree.getNextOpenEnd();

//            if (openEnd.topCoordinate.getY() > 900) {
//                openEnd.hasOpenEnd = false;
//                continue;
//            }

            int branchNumber = (int) p.random(Menu.getBranchNumberLow(), Menu.getBranchNumberHigh());

            float totalAngle = Menu.getBasicAngle() * branchNumber;
            float incrementAngle = totalAngle / (branchNumber - 1);
            float theta = (openEnd.growAngle - totalAngle / 2f) + p.random(Menu.getRelativeRotationMin(), Menu.getRelativeRotationMax());


            for (int j = 0; j < branchNumber; j++) {

                if (theta < -Menu.getTrimLimitAngle()) {
                    continue;
                }

                float branchLength = (p.random(Menu.getBranchLengthLow(), Menu.getBranchLengthHigh()));

                if (Menu.getStretchTopBranches()) {

                    branchLength *= PApplet.sin(theta);
                }

                Branch branch = new Branch(p);
                tree.insertFromTail(branch);

                branch.hasOpenEnd = true;
                branch.growAngle = theta;

                branch.endWidth = (openEnd.endWidth / branchNumber) * 1.25f;
                if (branch.endWidth < Menu.getMinBranchThickness()) {
                    branch.hasOpenEnd = false;
                }

                branch.rootCoordinate = openEnd.topCoordinate;
                branch.topCoordinate = AdditionalTools.localPolarInput(
                        branch.rootCoordinate.getX(),
                        branch.rootCoordinate.getY(),
                        branchLength,
                        theta);

                theta = theta + incrementAngle;

                if (theta + incrementAngle > p.PI + Menu.getTrimLimitAngle()) {
                    break;
                }
            }
            openEnd.hasOpenEnd = false;
        }
        while (tree.getNextOpenEnd() != null);
    }

    public void createTwigs() {

        tree.reopenThinBranches();

        do {

            Branch b = tree.getNextOpenBranch();

            //First (top) twig
            Twig twig = new Twig(p);
            attachTwig(twig, b.getLength() / 3, b.getMiddlePoint(), b.getGrowAngle());

            //second twig
            Twig twig2 = new Twig(p);
            attachTwig(twig2, b.getLength() / 3, b.getMiddlePoint(), b.getGrowAngle() - p.PI / 4);

            //third twig
            Coordinate thirdTwigRoot = AdditionalTools.localPolarInput(
                    b.rootCoordinate.getX(),
                    b.rootCoordinate.getY(),
                    b.getLength() * 0.4f,
                    b.getGrowAngle());

            Twig twig3 = new Twig(p);
            attachTwig(twig3, b.getLength() / 3, thirdTwigRoot, b.getGrowAngle() + p.PI / 4);

            //fourth twig
            Coordinate fourthTwigRoot = AdditionalTools.localPolarInput(
                    b.rootCoordinate.getX(),
                    b.rootCoordinate.getY(),
                    b.getLength() * 0.25f,
                    b.getGrowAngle());

            Twig twig4 = new Twig(p);
            attachTwig(twig4, b.getLength() / 3, fourthTwigRoot, b.getGrowAngle() - p.PI / 4);

            //fifth twig - to be exchanged with Branch b.
            Twig twig5 = new Twig(p);
            twig5.rootCoordinate = b.rootCoordinate;
            twig5.topCoordinate = twig.rootCoordinate;
            twig5.hasOpenEnd = false;

            tree.deleteNode(b);
            tree.insertFromTail(twig5);

        } while (tree.getNextOpenBranch() != null);

    }

    private void attachTwig(Twig twig, float length, Coordinate root, float angle) {

        twig.growAngle = angle;
        twig.twigLength = length;
        twig.rootCoordinate = root;
        twig.topCoordinate = AdditionalTools.localPolarInput(
                twig.rootCoordinate.getX(),
                twig.rootCoordinate.getY(),
                length,
                angle);
        twig.hasOpenEnd = true;

        tree.insertFromTail(twig);

    }

    public void generateLeaves() {

        do {
            Twig twig = (Twig) tree.getNextOpenEnd();

            for (Leaf leaf : twig.generateLeaves()) {
                tree.insertFromTail(leaf);

            }
            twig.hasOpenEnd = false;

        } while (tree.getNextOpenEnd() != null);
    }

    public void shadeDrawing() {

        for (int i = 1; i <= tree.length(); i++) {

            TreeComponent t = tree.getObjectAt(i);
            t.generateShading();

        }
    }


    public int returnLength() {

        return tree.length();
    }
}


