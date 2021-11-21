package com.kscm.trees.challenge12;

public class KthSmallestElementInBSTSolution2 {
    static int kth = 0;
    static int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        ans = 0;
        kth = 0;
        preOrder(root, k);
        return ans;

    }

    private void preOrder(TreeNode root, int k) {
        if(root == null)
            return;

        preOrder(root.left, k);

        kth += 1;

        if (kth == k)
            ans = root.val;

        preOrder(root.right, k);
    }

    public static void main(String[] args) {
        KthSmallestElementInBSTSolution2 solution = new KthSmallestElementInBSTSolution2();
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