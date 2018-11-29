//This project is in debt to the processing script supplied by Kung-Ta Tseng for producing generative trees. Thank you.
package com;

import com.util.Menu;
import com.util.NumberMachine;
import com.util.TreeGenerator;
import processing.core.PApplet;
import java.io.FileNotFoundException;


public class MainApp extends PApplet {


    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.welcomeMessage();
        menu.gatherTreeDesign();
        menu.processUserPreferences();

        PApplet.main("com.MainApp", args);

    }


    public void settings() {
        size(1500, 1200);

    }

    public void setup() {
        background(255);
        noLoop();

    }

    public void draw() {


        flipCoordinateSystem();

        TreeGenerator treeGenerator = new TreeGenerator(this);

        treeGenerator.createTrunk();

        treeGenerator.createBranches();

        treeGenerator.createSmallBranches();

        treeGenerator.createTwigs();

        treeGenerator.createLeaves();

        treeGenerator.makeTreeIrregular();

        treeGenerator.shadeDrawing();

        flipCoordinateSystem();

        attachSerialNumber();

        saveImageToDisk();

    }

    private void flipCoordinateSystem() {
        scale(1, -1);
        translate(0, -height);
    }


    private void saveImageToDisk() {
        hint(DISABLE_ASYNC_SAVEFRAME);
        save("testImage.jpg");
    }

    private void attachSerialNumber() {
        NumberMachine numberMachine = new NumberMachine(this);

        try {
            numberMachine.writeSerialNumber();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



}


