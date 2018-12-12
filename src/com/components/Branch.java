package com.components;

import com.util.TreeDesign;
import processing.core.PApplet;
import static processing.core.PConstants.SQUARE;


public class Branch extends TreeComponent{

    public Branch(PApplet p) {

        this.p = p;
        this.hasOpenEnd = false;

    }


    @Override
    public void generateShading() {

        p.stroke(TreeDesign.getColorOfBark()[0]+25, TreeDesign.getColorOfBark()[1]+25, TreeDesign.getColorOfBark()[2]+25);

        p.strokeWeight(this.endWidth);
        p.strokeCap(SQUARE);
        p.noFill();
        p.line(this.rootCoordinate.getX(),
                this.rootCoordinate.getY(),
                this.extendEndpoint().getX(),
                this.extendEndpoint().getY());

    }


}

