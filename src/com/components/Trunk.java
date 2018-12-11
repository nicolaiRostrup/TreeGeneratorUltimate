package com.components;

import com.util.Menu;
import processing.core.PApplet;

import static processing.core.PConstants.SQUARE;


public class Trunk extends TreeComponent {


    public Trunk(PApplet p) {
        this.p = p;
        this.hasOpenEnd = false;

    }

    @Override
    public void generateShading() {


        p.stroke(Menu.getColorOfBark()[0] + 25, Menu.getColorOfBark()[1] + 25, Menu.getColorOfBark()[2] + 25);

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
