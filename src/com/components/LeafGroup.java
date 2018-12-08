package com.components;

import com.lists.CoordinateList;
import com.util.Menu;
import processing.core.PApplet;


public class LeafGroup extends TreeComponent {

    public LeafGroup(PApplet p) {

        this.p = p;
        this.hasOpenEnd = false;

        coordList = new CoordinateList();

    }


    @Override
    public void makeIrregular() {

        for (int i = 2; i <= this.coordList.length(); i++) {
            float r = Menu.getRandomRadiusFactor() * Menu.getSizeFactor() * 25;
            Coordinate c = coordList.getCoordinateAt(i);
            c.x = p.random(c.x - r, c.x + r);
            c.y = p.random(c.y - r, c.y + r);
        }

    }

    @Override
    public void generateShading() {

        p.noStroke ();
        p.fill(Menu.getColorOfLeaves()[0],Menu.getColorOfLeaves()[1], Menu.getColorOfLeaves()[2] ,200);


        for (int i = 2; i <= this.coordList.length() ; i++) {
            if(exception()){
                p.fill(Menu.getColorOfLeaves()[0]+30,Menu.getColorOfLeaves()[1]+30, Menu.getColorOfLeaves()[2]+30 ,200);
            }

            Coordinate c = coordList.getCoordinateAt(i);

            float randomAngle = p.random(-p.PI/2, p.PI/2);
            p.pushMatrix();
            p.translate(c.x,c.y);
            p.rotate(randomAngle);
            p.ellipse(0, 0, 6,15);
            p.popMatrix();

        }


    }

    private boolean exception() {
        boolean isLeafLight = false;
        int exception = (int)p.random(1,30);
        if(exception == 2) {isLeafLight=true;}
        return isLeafLight;
    }


}

