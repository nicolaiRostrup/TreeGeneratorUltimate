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


    public Coordinate getObject(int j) {
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
}

