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


    public TreeComponent getTreeComponentAt(int j) {
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

    private Node findNode(TreeComponent t) {

        Node n = head;

        while (n != null) {

            if (n.t == t) {
                return n;

            }
            n = n.next;
        }

        return null;

    }


    public void deleteNode(TreeComponent t) {

        Node n = findNode(t);

        if (n == null) {
            return;
        }

        if (n == head) {
            head.next.previous = null;
            head = head.next;
            return;

        }
        if (n == tail) {
            tail.previous.next = null;
            tail = tail.previous;
            return;
        }

        n.previous.next = n.next;
        n.next.previous = n.previous;

    }

    public void insertBetween(TreeComponent a, TreeComponent b, TreeComponent c) {

        Node n = findNode(a);
//        Node m = findNode(b);
        Node i = new Node(c);

        if (n == null) {
            return;
        }

//        if (n.c.equals("findes ikke") || m.c.equals("findes ikke")) {
//            Main.printError("First or second target name doesn't exist");
//            return;
//        }

        int indexDifference = getIndex(a) - getIndex(b);

//        if (Math.abs(indexDifference) > 1) {
//            Main.printError("De to Navne er for langt fra hinanden. Vælg to fortløbne navne.");
//            return;
//        }

        if (indexDifference == -1) {
            insertNext(n, i);
        }

        if (indexDifference == +1) {
            insertPrevious(n, i);
        }

    }

    private void insertPrevious(Node a, Node b) {

        a.previous.next = b;
        b.previous = a.previous;
        b.next = a;
        a.previous = b;

    }

    private void insertNext(Node a, Node b) {

        a.next.previous = b;
        b.next = a.next;
        b.previous = a;
        a.next = b;

    }

    private int getIndex(TreeComponent t) {

        Node n = head;
        int i = 0;
        while (n != null) {
            i++;
            if (n.t == t) {
                return i;
            }
            n = n.next;
        }
        return -1;

    }


    public void swapData(TreeComponent t1, TreeComponent t2) {

        Node x = findNode(t1);
        Node y = findNode(t2);

        if (x == null || y == null) {
            return;
        }

//        if (x.data.equalsIgnoreCase("findes ikke") ||
//                y.data.equalsIgnoreCase("findes ikke")) {
//            Main.printError("Mindst et af de to navne findes ikke.");
//            return;
//        }

        x.t = y.t;
        y.t = t1;

    }

    public void swapNodes(TreeComponent t1, TreeComponent t2) {
        Node x = findNode(t1);
        Node y = findNode(t2);
        Node dummy = new Node("dummy object");

//        if (x.data.equalsIgnoreCase("findes ikke") ||
//                y.data.equalsIgnoreCase("findes ikke")) {
//            Main.printError("Mindst et af de to navne findes ikke.");
//            return;
//        }
//
//        if (x == y) {
//            Main.printError("De to navne er ens. Vælg to forskellige for at bytte");
//            return;
//        }

        processSwap(x, dummy);
        processSwap(y, x);
        processSwap(dummy, y);


    }

    private void processSwap(Node n1, Node n2) {


        if (n1 != head) {
            n1.previous.next = n2;
            n2.previous = n1.previous;
        }
        if (n1 != tail) {
            n1.next.previous = n2;
            n2.next = n1.next;
        }
        if (n1 == head) {
            head = n2;
            head.previous = null;
        }
        if (n1 == tail) {
            tail = n2;
            tail.next = null;
        }
    }


}







