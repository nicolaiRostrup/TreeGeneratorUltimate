package com.lists;

import com.components.Coordinate;
import com.components.TreeComponent;

public class Node {

    Node next = null;
    Node previous = null;

    TreeComponent t;

    Coordinate c;

    String s;

    public TreeComponent getT() {
        return t;
    }

    public Coordinate getC() {
        return c;
    }

    Node(TreeComponent t) {

        this.t = t;
    }

    Node(Coordinate c) {

        this.c = c;
    }

    //This constructor is used for dummy object creation only.
    Node(String s) {

        this.s = s;
    }
}