package com.components;


import processing.core.PApplet;

public abstract class TreeComponent {

    PApplet p;

    public boolean hasOpenEnd;
    public float endWidth;
    public float growAngle;

    public Coordinate topCoordinate;
    public Coordinate rootCoordinate;

    // This method all subclasses must implement

    abstract public void generateShading(int[] barkColor, int[] leafColor);

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

    public Coordinate extendEndpoint() {
        float extensionLength = 0.2f * this.getLength();
        return Coordinate.localPolarInput(
                this.topCoordinate,
                extensionLength,
                this.growAngle);

    }


}
