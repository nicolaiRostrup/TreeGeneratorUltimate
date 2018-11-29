package com.components;

import com.lists.CoordinateList;
import com.util.Menu;
import processing.core.PApplet;

public abstract class TreeComponent {

    PApplet p;

    public CoordinateList coordList;

    public boolean hasOpenEnd;

    public float growAngle;

    Coordinate topCoordinate;
    Coordinate bottomCoordinate;

// Two abstract methods that all subclasses must implement

    abstract public void makeIrregular();

    abstract public void generateShading();

// The below methods can be used by all subclasses if needed.

    Coordinate getIntermediateCoordinate() {

        float r = getRandomRadius();
        Coordinate middlePoint = getMiddlePoint(this);

        float x = p.random(middlePoint.x - r, middlePoint.x + r);
        float y = p.random(middlePoint.y - r, middlePoint.y + r);

        return new Coordinate(x, y);
    }

    private float getRandomRadius() {
        if (Menu.getRandomRadiusFactor() == 0) {
            return 0;
        } else {
            return getDistance(this) / Menu.getRandomRadiusFactor();
        }

    }

    private float getDistance(TreeComponent t) {

        return PApplet.dist(t.topCoordinate.x,
                t.topCoordinate.y,
                t.bottomCoordinate.x,
                t.bottomCoordinate.y);
    }

    private Coordinate getMiddlePoint(TreeComponent t) {

        float x = t.bottomCoordinate.x + (t.topCoordinate.x - t.bottomCoordinate.x) / 2f;
        float y = t.bottomCoordinate.y + (t.topCoordinate.y - t.bottomCoordinate.y) / 2f;

        return new Coordinate(x, y);

    }


}
