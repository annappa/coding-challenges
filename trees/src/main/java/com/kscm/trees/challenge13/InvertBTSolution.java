package com.kscm.trees.challenge13;

import java.util.Deque;
import java.util.LinkedList;

public class InvertBTSolution {
    /*
            6
        4       7
   3        5       8
 */
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        final Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            final TreeNode node = stack.pop();

            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        InvertBTSolution invertBTSolution = new InvertBTSolution();
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n8 = new TreeNode(8);
        TreeNode n4 = new TreeNode(4, n3, n5);
        TreeNode n7 = new TreeNode(7, null, n8);
        TreeNode n6 = new TreeNode(6, n4, n7);

        System.out.println(invertBTSolution.invertTree(n6));
    }
}

/*
            6
        4       7
   3        5       8
 */