package com.lists;

import com.components.Coordinate;
import java.util.EmptyStackException;


public class CoordinateList {

    private Node head = null;
    private Node tail = null;

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void insertFromHead(Coordinate c) {

        Node n = new Node(c);

        if (head == null) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head.previous = n;
            head = n;
        }

    }

    public void insertFromTail(Coordinate c) {

        Node n = new Node(c);

        if (tail == null) {
            tail = n;
            head = n;
        } else {
            n.previous = tail;
            tail.next = n;
            tail = n;
        }

    }


    public Coordinate getCoordinateAt(int j) {
        Node n = head;
        int i = 0;
        while (n != null) {
            i++;
            if (i == j) {

                return n.c;
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

    public void insertBeforeTail(Coordinate c) {

        Node n = new Node(c);


        if (tail == null || tail.previous == null) {

            throw new EmptyStackException();


        } else {
            n.previous = tail.previous;
            tail.previous.next = n;
            n.next = tail;
            tail.previous = n;
        }

    }

    public void insertAfterHead(Coordinate c) {

        Node n = new Node(c);


        if (head == null || head.next == null) {

            throw new EmptyStackException();


        } else {
            n.next = head.next;
            head.next.previous = n;
            n.previous = head;
            head.next = n;
        }

    }

    private Node findNode(Coordinate c) {

        Node n = head;

        while (n != null) {

            if (n.c == c) {
                return n;

            }
            n = n.next;
        }

        return null;

    }


    public void deleteNode(Coordinate c) {

        Node n = findNode(c);

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

        if (n == null) {
            return;
        }

        n.previous.next = n.next;
        n.next.previous = n.previous;

    }

    public void insertBetween(Coordinate a, Coordinate b, Coordinate c) {

        Node n = findNode(a);
        Node m = findNode(b);
        Node i = new Node(c);

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

    private int getIndex(Coordinate c) {

        Node n = head;
        int i = 0;
        while (n != null) {
            i++;
            if (n.c == c) {
                return i;
            }
            n = n.next;
        }
        return -1;

    }

    public Node getNodeAt(int j) {

        Node n = head;
        int i = 1;

        while (n != null) {

            if (i == j) {
                return n;
            }
            n = n.next;
            i++;
        }

        return null;
    }


    public void swapData(Coordinate c1, Coordinate c2) {

        Node x = findNode(c1);
        Node y = findNode(c2);

//        if (x.data.equalsIgnoreCase("findes ikke") ||
//                y.data.equalsIgnoreCase("findes ikke")) {
//            Main.printError("Mindst et af de to navne findes ikke.");
//            return;
//        }

        x.c = y.c;
        y.c = c1;

    }

    public void swapNodes(Coordinate c1, Coordinate c2) {
        Node x = findNode(c1);
        Node y = findNode(c2);
        Node dummy = new Node(new Coordinate(0, 0));

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

