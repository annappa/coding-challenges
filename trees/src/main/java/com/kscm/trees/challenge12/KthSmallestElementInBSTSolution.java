package com.kscm.trees.challenge12;

import java.util.ArrayList;

public class KthSmallestElementInBSTSolution {

    private void inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null)
            return;

        inorder(root.left, arr);

        arr.add(root.val);

        inorder(root.right, arr);
    }

    /*
        Since its BST, all the elements to the left of the root are less and all the elements to the right of the root are greater than the root value
        So if we traverse using inorder and store all the elements in an array, it will be sorted.
     */
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        inorder(root, nums);
        return nums.get(k - 1);
    }

    public static void main(String[] args) {
        KthSmallestElementInBSTSolution solution = new KthSmallestElementInBSTSolution();
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