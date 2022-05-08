package com.kscm.coding.linkedlist.challeng2;
// Java program to pairwise swap elements of a linked list

/* Linked list Node*/
class Node {
    int data;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}

public class LList {
    Node head; // head of list

    void pairWiseSwap()
    {
        Node temp = head;

        /* Traverse only till there are atleast 2 nodes left */
        while (temp != null && temp.next != null) {

            /* Swap the data */
            int k = temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next;
        }
    }

    /* Recursive function to pairwise swap elements
   of a linked list *//*
    static void pairWiseSwap(Node head)
    {
        *//* There must be at-least two nodes in the list *//*
        if (head != null && head.next != null) {

            *//* Swap the data *//*
            int k = head.data;
            head.data = head.next.data;
            head.next.data = k;
            head = head.next.next;

            *//* Call pairWiseSwap() for rest of the list *//*
            pairWiseSwap(head.next.next);
        }
    }*/

// This code contributed by aashish1995

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        LList llist = new LList();

        /* Created Linked List 1->2->3->4->5 */
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Linked List before calling pairWiseSwap() ");
        llist.printList();

        llist.pairWiseSwap();
        //llist.pairWiseSwap(llist.head);

        System.out.println("Linked List after calling pairWiseSwap() ");
        llist.printList();


        LList llist2 = new LList();

        /* Created Linked List 1->2->3->4->5 */
        llist2.push(5);
        llist2.push(4);

        System.out.println("Linked List before calling pairWiseSwap() ");
        llist2.printList();

        llist2.pairWiseSwap();

        System.out.println("Linked List after calling pairWiseSwap() ");
        llist2.printList();
    }
}