package com.components;

import com.lists.CoordinateList;
import com.util.Menu;
import processing.core.PApplet;


public class Twig extends TreeComponent {


    Twig(PApplet p) {

        this.p = p;
        this.hasOpenEnd = false;

        coordList = new CoordinateList();

    }

    @Override
    public void makeIrregular() {

        topCoordinate = this.coordList.getTail().getC();
        bottomCoordinate = this.coordList.getHead().getC();

        Coordinate firstIntermediateCoordinate = getIntermediateCoordinate();

        this.coordList.insertBeforeTail(firstIntermediateCoordinate);

    }

    @Override
    public void generateShading() {


        p.stroke(Menu.getColorOfBark()[0], Menu.getColorOfBark()[1], Menu.getColorOfBark()[2]);
        p.strokeWeight(3);
        p.noFill();

        p.beginShape();
        for (int i = 1; i <= this.coordList.length() ; i++) {
            Coordinate c = coordList.getObject(i);
            p.vertex(c.x, c.y);
        }
        p.endShape();


    }



}
