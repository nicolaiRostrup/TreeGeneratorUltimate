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

    public static Coordinate localPolarInput(float x, float y, float r, float theta) {

        float newX = (float) (r * Math.cos(theta));
        float newY = (float) (r * Math.sin(theta));

        newX = newX + x;
        newY = newY + y;

        return new Coordinate(newX, newY);

    }
}

