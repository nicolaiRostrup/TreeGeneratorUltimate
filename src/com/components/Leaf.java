package com.components;

import processing.core.PApplet;


public class Leaf extends TreeComponent {

    public float growAngle;
    public Coordinate rootCoordinate;
    private PApplet p;

    Leaf(PApplet p) {

        this.p = p;
        this.hasOpenEnd = false;

    }

    @Override
    public void generateShading(int[] barkColor, int[] leafColor) {

        p.stroke(leafColor[0], leafColor[1], leafColor[2]);

        if (checkForLeafColor() == 1) {
            p.fill(leafColor[3], leafColor[4], leafColor[5], 200);
        }

        if (checkForLeafColor() == 2) {
            p.fill(leafColor[6], leafColor[7], leafColor[8], 200);
        }


        p.pushMatrix();

        p.translate(this.rootCoordinate.getX(), this.rootCoordinate.getY());
        p.rotate(this.growAngle - p.PI / 2);

        p.beginShape();

        p.vertex(0, 4);
        p.vertex(-3, 7);
        p.vertex(-4, 11);
        p.vertex(0, 17);
        p.vertex(4, 11);
        p.vertex(3, 7);

        p.endShape(p.CLOSE);

        p.popMatrix();

    }

    private int checkForLeafColor() {

        float d = p.random(0, 1);
        if (d < 0.5f) {
            return 1;

        } else {
            return 2;
        }

    }

}
