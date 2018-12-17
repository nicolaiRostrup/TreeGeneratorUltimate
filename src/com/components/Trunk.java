package com.components;


import com.util.TreeDesign;
import processing.core.PApplet;

import static processing.core.PConstants.SQUARE;


public class Trunk extends TreeComponent {


    public Trunk(PApplet p) {
        this.p = p;
        this.hasOpenEnd = false;

    }

    @Override
    public void generateShading(int[] barkColor, int[] leafColor) {


        p.stroke(barkColor[0], barkColor[1], barkColor[2]);

        p.strokeWeight(this.endWidth);
        p.strokeCap(SQUARE);
        p.noFill();
        p.line(
                this.rootCoordinate.getX(),
                this.rootCoordinate.getY(),
                this.extendEndpoint().getX(),
                this.extendEndpoint().getY());


    }


}
