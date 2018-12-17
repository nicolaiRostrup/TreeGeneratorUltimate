package com.components;

public class Coordinate {

    float x;
    float y;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Coordinate(float x, float y) {
        this.x = x;
        this.y = y;

    }

    public static Coordinate localPolarInput(Coordinate coord, float r, float theta) {

        float newX = (float) (r * Math.cos(theta));
        float newY = (float) (r * Math.sin(theta));

        newX = newX + coord.getX();
        newY = newY + coord.getY();

        return new Coordinate(newX, newY);

    }
}

