package com.components;

import com.lists.CoordinateList;
import com.util.Menu;
import processing.core.PApplet;

import static processing.core.PConstants.SQUARE;

public class SmallBranch extends TreeComponent{


    public SmallBranch(PApplet p) {

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

        p.stroke(Menu.getColorOfBark()[0]+15, Menu.getColorOfBark()[1]+15, Menu.getColorOfBark()[2]+15);
        p.strokeWeight(8);
        p.strokeCap(SQUARE);
        p.noFill();

        p.beginShape();
        for (int i = 1; i <= this.coordList.length() ; i++) {

            Coordinate c = coordList.getObject(i);
            p.vertex(c.x, c.y);

        }
        p.endShape();

    }


}

