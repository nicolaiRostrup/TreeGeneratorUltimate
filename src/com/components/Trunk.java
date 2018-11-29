package com.components;

import com.lists.CoordinateList;
import com.util.Menu;
import processing.core.PApplet;



public class Trunk extends TreeComponent {


    public Trunk(PApplet p) {
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

        topCoordinate = firstIntermediateCoordinate;

        Coordinate secondIntermediateCoordinate = getIntermediateCoordinate();

        this.coordList.insertAfterHead(secondIntermediateCoordinate);

        bottomCoordinate = topCoordinate;
        topCoordinate = this.coordList.getTail().getC();

        Coordinate thirdIntermediateCoordinate = getIntermediateCoordinate();

        this.coordList.insertBeforeTail(thirdIntermediateCoordinate);

    }


    @Override
    public void generateShading() {

        p.noStroke();
        p.fill(Menu.getColorOfBark()[0]+35, Menu.getColorOfBark()[1]+35, Menu.getColorOfBark()[2]+35);

        float incrementNarrow = 2f;
        float stemWidth = 50f * Menu.getCrownWidthFactor() * 1.8f;

        p.beginShape();
        for (int i = 1; i <= this.coordList.length(); i++) {
            Coordinate c = coordList.getObject(i);
            p.vertex(c.x - stemWidth / 2 + incrementNarrow * i, c.y);
        }
        for (int i = this.coordList.length(); i >= 1; i--) {
            Coordinate c = coordList.getObject(i);
            p.vertex(c.x + stemWidth / 2 - incrementNarrow * i, c.y);
        }
        p.endShape();

    }


}
