package com.kscm.coding.linkedlist.challeng2;

import java.util.ArrayList;
import java.util.List;

class NodeP1 {
    private NodeP1 next;
    private int data;

    public NodeP1(int data) {
        this.data = data;
        this.next = null;
    }

    public NodeP1 getNext() {
        return next;
    }

    public void setNext(NodeP1 next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

public class LListP1 {
    NodeP1 head;
    NodeP1 tail;

    public LListP1() {
        head = null;
        tail = null;
    }

    public void insert(int data) {
        if(head == null) {
            head = new NodeP1(data);
            tail = head;
            return;
        }

        NodeP1 newNode = new NodeP1(data);
        tail.setNext(newNode);
        tail = newNode;
    }

    private void printList() {
        List<Integer> listArr = new ArrayList<>();
        if(head == null) {
            System.out.println("Empty");
        }

        NodeP1 cN = head;
        while(cN != null) {
            listArr.add(cN.getData());
            cN = cN.getNext();
        }

        System.out.println(listArr);
    }

    private void pairWiseSwapIterative() {
        NodeP1 cN = head;

        while(cN != null && cN.getNext() != null) {
            int k = cN.getData();
            cN.setData(cN.getNext().getData());
            cN.getNext().setData(k);

            cN = cN.getNext().getNext();
        }
    }


    /* Recursive function to pairwise swap elements
       of a linked list */
    static void pairWiseSwapRecursive(NodeP1 head)
    {
        /* There must be at-least two nodes in the list */
        if (head != null && head.getNext() != null) {

            /* Swap the node's data with data of next node *//*
            swap(head.data, head.next.data);*/
            int k = head.getData();
            head.setData(head.getNext().getData());
            head.getNext().setData(k);

            /* Call pairWiseSwap() for rest of the list */
            pairWiseSwapRecursive(head.getNext().getNext());
        }
    }

    public static void main(String[] args) {
        LListP1 lListP1 = new LListP1();
        lListP1.insert(1);
        lListP1.insert(2);
        lListP1.insert(3);
        lListP1.insert(4);
        lListP1.insert(5);

        lListP1.printList();
        //lListP1.pairWiseSwapIterative();
        lListP1.pairWiseSwapRecursive(lListP1.head);
        lListP1.printList();

        LListP1 lListP2 = new LListP1();
        lListP2.insert(1);
        lListP2.insert(2);

        lListP2.printList();
        //lListP2.pairWiseSwapIterative();
        lListP2.pairWiseSwapRecursive(lListP2.head);
        lListP2.printList();

        LListP1 lListP3 = new LListP1();
        lListP3.insert(1);

        lListP3.printList();
        //lListP3.pairWiseSwapIterative();
        lListP3.pairWiseSwapRecursive(lListP3.head);
        lListP3.printList();
    }
}
