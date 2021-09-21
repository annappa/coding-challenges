package com.kscm.trees.challenge2;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class BSTValidation2 {
    public boolean traverseInOrder(MyBinaryNode root, Integer prev) {
        if (root == null) {
            return true;
        }

        if (!traverseInOrder(root.getLeft(), prev)) {
            return false;
        }

        if(prev !=null && root.getValue() <= prev) {
            return false;
        }
        prev = root.getValue();
        return traverseInOrder(root.getRight(), prev);
    }

    public boolean isValidBST(MyBinaryNode root) {
        Integer prev=null;
        return traverseInOrder(root, prev);
    }

    public static void main(String[] args) {
        BSTValidation2 bstValidation = new BSTValidation2();
        MyBinarySearchTree tree = new MyBinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(21);
        tree.insert(1);
        tree.insert(6);
        tree.insert(15);
        tree.insert(170);
        tree.printTree();
        //           9
        //      4         21
        //    1   6   15       170

        System.out.println(bstValidation.isValidBST(tree.getRoot())); // Since we are constructing binary tree here already, result will be always true
    }
}
