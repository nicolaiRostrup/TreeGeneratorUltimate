package com.components;


import com.util.AdditionalTools;
import com.util.Menu;
import processing.core.PApplet;

public abstract class TreeComponent {

    PApplet p;


    public boolean hasOpenEnd;
    public float endWidth;
    public float growAngle;

    public Coordinate topCoordinate;
    public Coordinate rootCoordinate;

    // This method all subclasses must implement

    abstract public void generateShading();

    //The below methods all subclasses can use freely;

    public float getLength() {

        return PApplet.dist(
                this.topCoordinate.x,
                this.topCoordinate.y,
                this.rootCoordinate.x,
                this.rootCoordinate.y);
    }

    public Coordinate getMiddlePoint() {

        float x = this.rootCoordinate.x + (this.topCoordinate.x - this.rootCoordinate.x) / 2f;
        float y = this.rootCoordinate.y + (this.topCoordinate.y - this.rootCoordinate.y) / 2f;

        return new Coordinate(x, y);

    }

    public float getGrowAngle() {

        return PApplet.atan2(this.topCoordinate.y - this.rootCoordinate.y, this.topCoordinate.x - this.rootCoordinate.x);
    }

    public Coordinate extendEndpoint() {
        float extensionLength = 0.35f * this.getLength() * this.endWidth / Menu.getInitialWidth();
        Coordinate extendedTopCoordinate = AdditionalTools.localPolarInput(
                this.topCoordinate.getX(),
                this.topCoordinate.getY(),
                extensionLength,
                this.growAngle);
        return extendedTopCoordinate;

    }

}
