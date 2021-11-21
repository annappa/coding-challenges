package com.kscm.trees.challenge12;

import java.util.LinkedList;

public class KthSmallestElementInBSTSolution3 {
    static int kth = 0;
    static int ans = 0;

    /*
            6
        4       7
   3        5       8
 */
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();

            if (--k == 0)
                return root.val;

            root = root.right;
        }
    }

    public static void main(String[] args) {
        KthSmallestElementInBSTSolution3 solution = new KthSmallestElementInBSTSolution3();
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n8 = new TreeNode(8);
        TreeNode n4 = new TreeNode(4, n3, n5);
        TreeNode n7 = new TreeNode(7, null, n8);
        TreeNode n6 = new TreeNode(6, n4, n7);

        System.out.println(solution.kthSmallest(n6, 2));
        System.out.println(solution.kthSmallest(n6, 6));
    }
}

/*
            6
        4       7
   3        5       8
 */