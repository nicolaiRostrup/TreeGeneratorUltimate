package com.components;


import com.enums.BranchType;
import processing.core.PApplet;


public class BranchObject {

    private PApplet p;
    private BranchType branchType;

    public BranchObject(PApplet p, BranchType branchType) {

        this.p = p;
        this.branchType = branchType;

    }

    public TreeComponent returnMe(){

        if (branchType == BranchType.BRANCH){return new Branch(p);}
        if (branchType == BranchType.SMALLBRANCH){return new SmallBranch(p);}
        if (branchType == BranchType.TWIG){return new Twig(p);}
        else return null;
    }


}
