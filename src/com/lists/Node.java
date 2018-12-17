package com.lists;

import com.components.TreeComponent;

public class Node {

    Node next = null;
    Node previous = null;

    TreeComponent t;


    Node(TreeComponent t) {

        this.t = t;
    }

    Node() {

    }


}