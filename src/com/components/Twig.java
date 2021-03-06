package com.components;

import processing.core.PApplet;

import static processing.core.PConstants.SQUARE;



public class Twig extends TreeComponent {

    private Leaf[] leavesList = new Leaf[5];
    private PApplet p;

    public Twig(PApplet p) {

        this.p = p;

    }


    public Leaf[] generateLeaves() {

        float twigLength = this.getLength();

        Leaf leaf1 = new Leaf(p);
        leaf1.growAngle = this.growAngle;
        leaf1.rootCoordinate = this.topCoordinate;
        leavesList[0] = leaf1;

        Leaf leaf2 = new Leaf(p);
        Coordinate secondLeafRoot = Coordinate.localPolarInput(rootCoordinate,twigLength / 3,growAngle);
        leaf2.growAngle = growAngle - p.PI / 4;
        leaf2.rootCoordinate = secondLeafRoot;
        leavesList[1] = leaf2;

        Leaf leaf3 = new Leaf(p);
        Coordinate thirdLeafRoot = Coordinate.localPolarInput(rootCoordinate,(twigLength / 3) * 2, growAngle);
        leaf3.growAngle = growAngle - p.PI / 4;
        leaf3.rootCoordinate = thirdLeafRoot;
        leavesList[2] = leaf3;

        Leaf leaf4 = new Leaf(p);
        Coordinate fourthLeafRoot = Coordinate.localPolarInput(rootCoordinate,(twigLength / 3) * 2, growAngle);
        leaf4.growAngle = growAngle + p.PI / 4;
        leaf4.rootCoordinate = fourthLeafRoot;
        leavesList[3] = leaf4;

        Leaf leaf5 = new Leaf(p);
        Coordinate fifthLeafRoot = Coordinate.localPolarInput(rootCoordinate,twigLength / 3, growAngle);
        leaf5.growAngle = growAngle + p.PI / 4;
        leaf5.rootCoordinate = fifthLeafRoot;
        leavesList[4] = leaf5;

        return leavesList;
    }

    public void generateShading(int[] barkColor, int[] leafColor) {

        p.stroke(15, 0, 0);

        p.strokeWeight(0.25f);
        p.strokeCap(SQUARE);
        p.noFill();
        p.line(
                this.rootCoordinate.getX(),
                this.rootCoordinate.getY(),
                this.topCoordinate.getX(),
                this.topCoordinate.getY());

    }

}

