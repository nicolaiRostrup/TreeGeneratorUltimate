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
    public void generateShading() {

        p.stroke(9, 80, 1);

        if (checkForLeafColor() == 1) {
            p.fill(39, 194, 1, 200);
        }

        if (checkForLeafColor() == 2) {
            p.fill(25, 120, 5, 200);
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
