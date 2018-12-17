package com.util;

public final class TreeDesign {

    //this class is designed as a singleton:
    private static final TreeDesign INSTANCE = new TreeDesign();

    //trunk related parameters
    private  float trunkHeight;
    private  float initialWidth;
    private  int maxTrunkSections;
    private int bigBranchProbability;
    //branch related parameters
    private  float basicAngle = 0.5f;
    private  float relativeRotation;
    private  int branchNumberLow = 2;
    private  int branchNumberHigh;
    private  float branchLengthLow;
    private  float branchLengthHigh;
    private  float minBranchThickness;
    private  float trimLimitAngle;
    private  boolean stretchTopBranches;
    //colors
    private  int[] colorOfBark;
    private  int[] colorOfLeaves;
    //leaves
    private boolean skipLeaves = false;

    private TreeDesign() {}


    public  static TreeDesign getInstance() {
        return INSTANCE;
    }

    public  int getBranchNumberLow() {
        return branchNumberLow;
    }

    public void setBranchNumberLow(int branchNumberLow) {
        this.branchNumberLow = branchNumberLow;
    }

    public  int getBranchNumberHigh() {
        return branchNumberHigh;
    }

    public void setBranchNumberHigh(int branchNumberHigh) {
        this.branchNumberHigh = branchNumberHigh;
    }

    public  float getBranchLengthLow() {
        return branchLengthLow;
    }

    public void setBranchLengthLow(float branchLengthLow) {
        this.branchLengthLow = branchLengthLow;
    }

    public  float getBranchLengthHigh() {
        return branchLengthHigh;
    }

    public void setBranchLengthHigh(float branchLengthHigh) {
        this.branchLengthHigh = branchLengthHigh;
    }

    public  int[] getColorOfBark() {
        return colorOfBark;
    }

    public void setColorOfBark(int[] colorOfBark) {
        this.colorOfBark = colorOfBark;
    }

    public  int[] getColorOfLeaves() {return colorOfLeaves;}

    public void setColorOfLeaves(int[] colorOfLeaves) {
        this.colorOfLeaves = colorOfLeaves;
    }

    public  float getInitialWidth() {
        return initialWidth;
    }

    public void setInitialWidth(float initialWidth) {
        this.initialWidth = initialWidth;
    }

    public  float getTrunkHeight() {
        return trunkHeight;
    }

    public void setTrunkHeight(float trunkHeight) {
        this.trunkHeight = trunkHeight;
    }

    public  float getBasicAngle() {
        return basicAngle;
    }

    public void setBasicAngle(float basicAngle) {
        this.basicAngle = basicAngle;
    }

    public  int getMaxTrunkSections() {
        return maxTrunkSections;
    }

    public void setMaxTrunkSections(int maxTrunkSections) {
        this.maxTrunkSections = maxTrunkSections;
    }

    public  float getMinBranchThickness() {
        return minBranchThickness;
    }

    public void setMinBranchThickness(float minBranchThickness) {
        this.minBranchThickness = minBranchThickness;
    }

    public  boolean getStretchTopBranches() {
        return stretchTopBranches;
    }

    public void setStretchTopBranches(boolean stretchTopBranches) {
        this.stretchTopBranches = stretchTopBranches;
    }

    public float getRelativeRotation() {
        return relativeRotation;
    }

    public void setRelativeRotation(float relativeRotation) {
        this.relativeRotation = relativeRotation;
    }

    public float getTrimLimitAngle() {
        return trimLimitAngle;
    }

    public void setTrimLimitAngle(float trimLimitAngle) {
        this.trimLimitAngle = trimLimitAngle;
    }

    public int getBigBranchProbability() {
        return bigBranchProbability;
    }

    public void setBigBranchProbability(int bigBranchProbability) {
        this.bigBranchProbability = bigBranchProbability;
    }

    public boolean getSkipLeaves() {
        return skipLeaves;
    }

    public void setSkipLeaves(boolean skipLeaves) {
        this.skipLeaves = skipLeaves;
    }
}
