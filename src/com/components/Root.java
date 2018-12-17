package com.components;

import processing.core.PApplet;


public class Root extends TreeComponent {

    public Coordinate bottomLeft;
    public Coordinate bottomRight;


    public Root(PApplet p) {

        this.p = p;

    }


    @Override
    public void generateShading(int[] barkColor, int[] leafColor) {

        p.noStroke();
        p.fill(barkColor[0], barkColor[1], barkColor[2]);

        p.triangle(this.topCoordinate.getX(),
                this.topCoordinate.getY(),
                bottomLeft.getX(),
                bottomLeft.getY(),
                bottomRight.getX(),
                bottomRight.getY());


    }
}
