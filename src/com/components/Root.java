package com.components;

import com.util.Menu;
import processing.core.PApplet;


public class Root extends TreeComponent {

    public Root(PApplet p) {

        this.p = p;
        this.hasOpenEnd = false;


    }


    @Override
    public void generateShading() {

        Coordinate bottomLeft = new Coordinate(rootCoordinate.getX() - 60, rootCoordinate.getY());
        Coordinate bottomRight = new Coordinate(rootCoordinate.getX() + 85, rootCoordinate.getY());

        p.noStroke();
        p.fill(Menu.getColorOfBark()[0] + 25, Menu.getColorOfBark()[1] + 25, Menu.getColorOfBark()[2] + 25);

        p.triangle(this.topCoordinate.getX(),
                this.topCoordinate.getY(),
                bottomLeft.getX(),
                bottomLeft.getY(),
                bottomRight.getX(),
                bottomRight.getY());


    }
}
