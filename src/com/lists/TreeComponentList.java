package com.lists;

import com.components.TreeComponent;

public class TreeComponentList {


    private Node head = null;
    private Node tail = null;


    public void insertFromHead(TreeComponent t) {

        Node n = new Node(t);

        if (head == null) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head.previous = n;
            head = n;
        }

    }

    public void insertFromTail(TreeComponent t) {

        Node n = new Node(t);

        if (tail == null) {
            tail = n;
            head = n;
        } else {
            n.previous = tail;
            tail.next = n;
            tail = n;
        }

    }


    public TreeComponent nextOpenEnd() {

        Node n = head;

        if (n.t.hasOpenEnd) {return n.t;}

        while (n.next != null) {

            n = n.next;

            if (n.t.hasOpenEnd) {
                return n.t;
            }

        }
        return null;
    }

    public int openEndCount() {
        Node n = head;
        int count = 0;

        while (n != null) {

            if (n.t.hasOpenEnd) {
                count++;
            }

            n = n.next;

        }
        return count;
    }


    public TreeComponent getObject(int j) {
        Node n = head;
        int i = 0;
        while (n != null) {
            i++;
            if (i == j) {

                return n.t;
            }

            n = n.next;

        }

        return null;
    }


    public int length() {
        if (head == null) return 0;

        if (head.next == null) return 1;


        else {
            Node n = head;
            int i = 0;
            while (n != null) {

                i++;
                n = n.next;
            }
            return i;
        }

    }
}







