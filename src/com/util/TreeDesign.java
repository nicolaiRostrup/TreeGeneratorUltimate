package com.util;

public final class TreeDesign {

    //this class is designed as a singleton:

    private static final TreeDesign INSTANCE = new TreeDesign();

    private TreeDesign() {}

    public  static TreeDesign getInstance() {
        return INSTANCE;
    }

    //todo: create full list of key variables and collect these in a menu object, which is returned to treegenerator...

    private  float basicAngle = 0.5f;
    private  float trunkHeight = 325f;
    private  float initialWidth = 50f;
    private  float relativeRotationMax = 0.45f;
    private  float relativeRotationMin = -0.45f;
    private  float bigBranchAngleLow = 0.45f;
    private  int branchNumberLow = 2;
    private  int branchNumberHigh = 4;
    private  float branchLengthLow = 60f;
    private  float branchLengthHigh = 100f;
    private  int maxTrunkSections = 6;
    private  float bigBranchAngleHigh = 0.85f;
    private  float minBranchThickness = 0.4f;
    private  float trimLimitAngle = 1.5f;
    private  static int[] colorOfBark = new int[]{50, 21, 6};
    private  static int[] colorOfLeaves = new int[]{247, 134, 9};
    private  boolean stretchTopBranches = false;


    public  int getBranchNumberLow() {
        return branchNumberLow;
    }

    public  int getBranchNumberHigh() {
        return branchNumberHigh;
    }

    public  float getBranchLengthLow() {
        return branchLengthLow;
    }

    public  float getBranchLengthHigh() {
        return branchLengthHigh;
    }

    public  static int[] getColorOfBark() {
        return colorOfBark;
    }

    public  static int[] getColorOfLeaves() {

        return colorOfLeaves;
    }

    public  float getInitialWidth() {
        return initialWidth;
    }

    public  float getRelativeRotationMin() {
        return relativeRotationMin;
    }

    public  float getRelativeRotationMax() {
        return relativeRotationMax;
    }

    public  float getTrunkHeight() {
        return trunkHeight;
    }

    public  float getBasicAngle() {
        return basicAngle;
    }

    public  int getMaxTrunkSections() {
        return maxTrunkSections;
    }

    public  float getBigBranchAngleLow() {
        return bigBranchAngleLow;
    }

    public  float getBigBranchAngleHigh() {
        return bigBranchAngleHigh;
    }

    public  float getMinBranchThickness() {
        return minBranchThickness;
    }

    public  float getTrimLimitAngle() {
        return trimLimitAngle;
    }

    public  boolean getStretchTopBranches() {
        return stretchTopBranches;
    }


}
