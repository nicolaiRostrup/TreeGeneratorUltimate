//This project is in debt to the processing script supplied by Kung-Ta Tseng for producing generative trees. Thank you.
package com;

import com.util.Menu;
import com.util.NumberMachine;
import com.util.TreeDesign;
import com.util.TreeGenerator;
import processing.core.PApplet;
import java.io.FileNotFoundException;


public class MainApp extends PApplet {


    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.welcomeMessage();
        menu.gatherTreeDesign();
//        menu.processUserPreferences();

        PApplet.main("com.MainApp", args);

    }


    public void settings() {
        size(1400, 1000);

    }

    public void setup() {
        background(255);
        noLoop();

    }

    public void draw() {


        flipCoordinateSystem();

        TreeGenerator treeGenerator = new TreeGenerator(this);

        treeGenerator.createBaseTrunk();

        treeGenerator.createTrunkSections();

        treeGenerator.createTopTrunk();

        treeGenerator.createBranches();

        treeGenerator.createTwigs();

        treeGenerator.generateLeaves();

        treeGenerator.shadeDrawing();

        flipCoordinateSystem();

        attachSerialNumber();

        saveImageToDisk();

        System.out.println("Tree drawing complete");
        System.out.println("Total number of tree components: " + treeGenerator.returnLength());

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


