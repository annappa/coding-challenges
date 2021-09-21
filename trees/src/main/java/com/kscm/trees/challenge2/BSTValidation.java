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

public class BSTValidation {
    public boolean validate(MyBinaryNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((low != null && root.getValue() <= low) || (high != null && root.getValue() >= high)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validate(root.getRight(), root.getValue(), high) && validate(root.getLeft(), low, root.getValue());
    }

    public boolean isValidBST(MyBinaryNode root) {
        return validate(root, null, null);
    }

    public static void main(String[] args) {
        BSTValidation bstValidation = new BSTValidation();
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
        System.out.println(bstValidation.isValidBST(tree.getRoot())); // Since we are constructing binary tree here already, result will be always true
    }
}
