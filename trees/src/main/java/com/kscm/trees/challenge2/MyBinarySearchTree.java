package com.kscm.trees.challenge2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyBinarySearchTree {
    private MyBinaryNode root;

    public MyBinarySearchTree() {
        root = null;
    }

    public MyBinaryNode getRoot() {
        return this.root;
    }

    public void insert(int value) {
        if(root == null) {
            root = new MyBinaryNode(value);
            return;
        }
        MyBinaryNode currentNode = root;
        while (true) {
            if (currentNode.getValue() > value) {
                if(currentNode.getLeft() == null) {
                    currentNode.setLeft(new MyBinaryNode(value));
                    return;
                }
                currentNode = currentNode.getLeft();
            } else {
                if(currentNode.getRight() == null) {
                    currentNode.setRight(new MyBinaryNode(value));
                    return;
                }
                currentNode = currentNode.getRight();
            }
        }
    }

    public MyBinaryNode lookup(int value) {
        if(root == null) {
            return null;
        }
        MyBinaryNode currentNode = root;
        while (currentNode != null) {
            if(value < currentNode.getValue()) {
                currentNode = currentNode.getLeft();
            } else if(value > currentNode.getValue()) {
                currentNode = currentNode.getRight();
            } else {
                return currentNode;
            }
        }
        return null;
    }

    public List<Integer> breathFirstSearchIteratively() {
        MyBinaryNode currentNode = root;
        List<Integer> list = new ArrayList<>();
        Queue<MyBinaryNode> queue = new LinkedList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            list.add(currentNode.getValue());
            if(currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }

            if(currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }
        return list;
    }

    public List<Integer> breathFirstSearchRecursively() {
        Queue<MyBinaryNode> queue = new LinkedList<>();
        queue.add(root);
        return breathFirstSearchRecursively(queue, new ArrayList<>());
    }

    private List<Integer> breathFirstSearchRecursively(Queue<MyBinaryNode> queue, List<Integer> list) {
        if (queue.isEmpty()) {
            return list;
        }
        MyBinaryNode currentNode = queue.poll();
        list.add(currentNode.getValue());
        if (currentNode.getLeft() != null) {
            queue.add(currentNode.getLeft());
        }

        if (currentNode.getRight() != null) {
            queue.add(currentNode.getRight());
        }
        return breathFirstSearchRecursively(queue, list);
    }

    public List<Integer> depthFirstSearchInOrder() {
        return depthFirstSearchInOrder(root, new ArrayList<>());
    }

    private List<Integer> depthFirstSearchInOrder(MyBinaryNode node, ArrayList<Integer> list) {
        if(node.getLeft() != null) {
            depthFirstSearchInOrder(node.getLeft(), list);
        }
        list.add(node.getValue());
        if(node.getRight() != null) {
            depthFirstSearchInOrder(node.getRight(), list);
        }
        return list;
    }

    public List<Integer> depthFirstSearchPreOrder() {
        return depthFirstSearchPreOrder(root, new ArrayList<>());
    }

    private List<Integer> depthFirstSearchPreOrder(MyBinaryNode node, ArrayList<Integer> list) {
        list.add(node.getValue());
        if(node.getLeft() != null) {
            depthFirstSearchPreOrder(node.getLeft(), list);
        }
        if(node.getRight() != null) {
            depthFirstSearchPreOrder(node.getRight(), list);
        }
        return list;
    }

    public List<Integer> depthFirstSearchPostOrder() {
        return depthFirstSearchPostOrder(root, new ArrayList<>());
    }

    private List<Integer> depthFirstSearchPostOrder(MyBinaryNode node, ArrayList<Integer> list) {
        if(node.getLeft() != null) {
            depthFirstSearchPostOrder(node.getLeft(), list);
        }
        if(node.getRight() != null) {
            depthFirstSearchPostOrder(node.getRight(), list);
        }
        list.add(node.getValue());
        return list;
    }

    int count = 0;
    public void printTree() {
        count = 0;
        printTree(root);
    }


    private void printTree(MyBinaryNode node) {
        System.out.print(node.getValue());
        System.out.println();
        count++;
        if(node.getLeft() != null) {
            //System.out.print("\t".repeat(Math.max(0, count)) + "Left: ");
            //repeated = new String(new char[n]).replace("\0", s);
            System.out.print(new String(new char[Math.max(0, count)]).replace("\0", "\t") + "Left: ");
            System.out.print("\t");
            printTree(node.getLeft());
        }
        if(node.getRight() != null) {
            //System.out.print("\t".repeat(Math.max(0, count)) +"Right: ");
            System.out.print(new String(new char[Math.max(0, count)]).replace("\0", "\t") +"Right: ");
           // System.out.print("\t" +"Right: ");
            printTree(node.getRight());
        }
        count--;
    }

    public static void main(String[] args) {
        MyBinarySearchTree tree = new MyBinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(21);
        tree.insert(1);
        tree.insert(6);
        tree.insert(15);
        tree.insert(170);
        tree.printTree();
        //tree.remove(20);
        //tree.remove(4);
        tree.printTree();
        tree.insert(20);
        tree.insert(18);
        tree.insert(10);
        tree.printTree();
        //tree.remove(170);
        tree.printTree();
        //           9
        //      4         21
        //    1   6   15       170
        //          10   20
        //             18
        System.out.println("Breath first search " + tree.breathFirstSearchIteratively()); // [9, 4, 21, 1, 6, 15, 170, 10, 20, 18]
        System.out.println("Breath first search " + tree.breathFirstSearchRecursively()); // [9, 4, 21, 1, 6, 15, 170, 10, 20, 18]
        System.out.println("Depth first search - in order " + tree.depthFirstSearchInOrder()); // [1, 4, 6, 9, 10, 15, 18, 20, 21, 170]
        System.out.println("Depth first search - pre order " + tree.depthFirstSearchPreOrder()); // [9, 4, 1, 6, 21, 15, 10, 20, 18, 170]
        System.out.println("Depth first search - post order " + tree.depthFirstSearchPostOrder()); // [1, 6, 4, 10, 18, 20, 15, 170, 21, 9]
    }
}
