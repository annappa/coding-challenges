package com.kscm.coding.linkedlist.challenge3;

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

    public void swapNodes(int x, int y) {
        // Nothing to do if x and y are same
        if (x == y)
            return;

        // Search for x (keep track of prevX and CurrX)
        NodeP1 prevX = null, currX = head;
        while (currX != null && currX.getData() != x) {
            prevX = currX;
            currX = currX.getNext();
        }

        // Search for y (keep track of prevY and currY)
        NodeP1 prevY = null, currY = head;
        while (currY != null && currY.getData() != y) {
            prevY = currY;
            currY = currY.getNext();
        }

        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;

        // If x is not head of linked list
        if (prevX != null)
            prevX.setNext(currY);
        else // make y the new head
            head = currY;

        // If y is not head of linked list
        if (prevY != null)
            prevY.setNext(currX);
        else // make x the new head
            head = currX;

        // Swap next pointers
        NodeP1 temp = currX.getNext();
        currX.setNext(currY.getNext());
        currY.setNext(temp);
    }

    public static void main(String[] args) {
        LListP1 lListP1 = new LListP1();
        lListP1.insert(1);
        lListP1.insert(2);
        lListP1.insert(3);
        lListP1.insert(4);
        lListP1.insert(5);

        lListP1.printList();
        lListP1.swapNodes(2, 4);
        System.out.println("After Swap of 2 and 4-->");
        lListP1.printList();
        System.out.println("-------------------------");

        LListP1 lListP2 = new LListP1();
        lListP2.insert(1);
        lListP2.insert(2);

        lListP2.printList();
        lListP2.swapNodes(1, 3);
        System.out.println("After Swap or 1 and 3-->");
        lListP2.printList();
        System.out.println("-------------------------");

        LListP1 lListP3 = new LListP1();
        lListP3.insert(1);
        lListP3.insert(2);
        lListP3.insert(3);
        lListP3.insert(4);
        lListP3.insert(5);

        lListP3.printList();
        lListP3.swapNodes(1, 5);
        System.out.println("After Swap or 1 and 5-->");
        lListP3.printList();
        System.out.println("-------------------------");
    }
}
