package com.util;

import processing.core.PApplet;
import processing.core.PFont;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class NumberMachine {


    private PApplet p;

    public NumberMachine(PApplet p) {

        this.p = p;
    }

    public void writeSerialNumber() throws FileNotFoundException {

        PFont f;
        f = p.createFont("Courier", 14, true);

        int thisSerialNumber = getLastSerialNumber() + 1;
        String serialNumber = String.format("%010d", thisSerialNumber);

        p.textFont(f, 14);
        p.fill(0);
        p.text(serialNumber, p.width - 100, p.height - 30);

        try {
            updateLastSerialNumber(thisSerialNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private int getLastSerialNumber() throws FileNotFoundException {

        FileReader fr = new FileReader("D:\\programmering\\TreeGenerator\\lastSerialNumber.txt");
        Scanner sc = new Scanner(fr);
        String thisLine = sc.nextLine();
        sc.close();

        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parseInt(thisLine);

    }

    private void updateLastSerialNumber(Integer thisSerialNumber) throws IOException {

        String newSerialNumber = thisSerialNumber.toString();

        FileWriter fw = new FileWriter("D:\\programmering\\TreeGenerator\\lastSerialNumber.txt");
        try {
            fw.write(newSerialNumber);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        fw.close();

    }

}


