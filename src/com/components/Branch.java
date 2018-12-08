package com.components;

import com.lists.CoordinateList;
import com.util.Menu;
import processing.core.PApplet;
import static processing.core.PConstants.SQUARE;



public class Branch extends TreeComponent{

    public Branch(PApplet p) {

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

        p.stroke(Menu.getColorOfBark()[0]+25, Menu.getColorOfBark()[1]+25, Menu.getColorOfBark()[2]+25);
        p.strokeWeight(17);
        p.strokeCap(SQUARE);
        p.noFill();


        p.beginShape();
        for (int i = 1; i <= this.coordList.length() ; i++) {

            Coordinate c = coordList.getCoordinateAt(i);
            p.vertex(c.x, c.y);

        }
        p.endShape();

    }


}

