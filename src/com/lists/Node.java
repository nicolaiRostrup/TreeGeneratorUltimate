package com.lists;

import com.components.Coordinate;
import com.components.TreeComponent;

public class Node {

    Node next = null;
    Node previous = null;

    TreeComponent t;

    Coordinate c;

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
}