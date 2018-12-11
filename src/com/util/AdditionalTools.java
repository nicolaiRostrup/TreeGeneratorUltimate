package com.util;

import com.components.Coordinate;
import processing.core.PApplet;
import static processing.core.PApplet.atan;


public class AdditionalTools {


    public static float[] toPolar(float x, float y) {

        float r = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        float theta = atan(y / x);

        return new float[]{r, theta};

    }

    public static Coordinate toCartesian(float r, float theta) {

        float x = (float) (r * Math.cos(theta));

        float y = (float) (r * Math.sin(theta));

        return new Coordinate(x, y);

    }

    public static Coordinate localPolarInput(float x, float y, float r, float theta) {

        float newX = (float) (r * Math.cos(theta));

        float newY = (float) (r * Math.sin(theta));

        newX = newX + x;
        newY = newY + y;

        return new Coordinate(newX, newY);

    }

    public static Coordinate localCartesianInput(float x, float y, float v, float w) {

        return new Coordinate (x+v, y+w);
    }


    public static float getAngleFromVector(float x, float y, float v, float w) {

        return PApplet.atan2(w - y, v - x);
    }



}

