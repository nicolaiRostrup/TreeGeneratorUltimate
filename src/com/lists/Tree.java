package com.lists;


import com.components.Branch;
import com.components.TreeComponent;
import com.components.Trunk;
import processing.core.PApplet;

public class Tree {

    PApplet p;
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

        if (n == head) {
            head.next.previous = null;
            head = head.next;
            return;

        }
        if (n == tail) {
            tail.previous.next = null;
            tail = tail.previous;
            return;
        } else if (n != null) {

            n.previous.next = n.next;
            n.next.previous = n.previous;
        }

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


    public TreeComponent getNextOpenEnd() {
        Node n = head;

        while (n != null) {

            if (n.t.hasOpenEnd) {

                return n.t;
            }

            n = n.next;
        }
        return null;

    }


    public TreeComponent getObjectAt(int i) {

        Node n = head;
        int j = 0;

        while (n != null) {
            j++;
            if (i == j) {

                return n.t;
            }
            n = n.next;
        }
        return null;

    }


    public Trunk getNextOpenTrunk() {
        Node n = head;
        Trunk trunk = new Trunk(p);

        while (n != null) {

            if (n.t.hasOpenEnd && n.t.getClass().isInstance(trunk)) {
                return (Trunk) n.t;
            }
            n = n.next;
        }
        return null;

    }

    public Branch getNextOpenBranch() {
        Node n = head;
        Branch branch = new Branch(p);

        while (n != null) {

            if (n.t.hasOpenEnd && n.t.getClass().isInstance(branch)) {
                return (Branch) n.t;
            }
            n = n.next;
        }
        return null;

    }


    public void reopenThinBranches(float minBranchThickness) {

        Node n = head;
        Branch branch = new Branch(p);
        int counter = 1;

        while (n != null) {

            if (n.t.endWidth < minBranchThickness
                    && n.t.getClass().isInstance(branch)
                    && counter % 2 == 0) {
                n.t.hasOpenEnd = true;
            }
            counter++;
            n = n.next;
        }

    }

    public void swapNodes(TreeComponent c1, TreeComponent c2) {
        Node x = findNode(c1);
        Node y = findNode(c2);
        Node temp = new Node();

        processSwap(x, temp);
        processSwap(y, x);
        processSwap(temp, y);

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
