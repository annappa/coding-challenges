package com.kscm.trees.challenge12;

public class KthSmallestElementInBSTSolution2 {
    static int kth = 0;
    static int kthP1 = 0;
    static int ans = 0;
    static int ansP1 = 0;

    public int kthSmallest(TreeNode root, int k) {
        ans = 0;
        kth = 0;
        inOrder(root, k);
        return ans;

    }

    private void inOrder(TreeNode root, int k) {
        if(root == null)
            return;

        inOrder(root.left, k);

        kth += 1;

        if (kth == k) {
            ans = root.val;
            return;
        }

        inOrder(root.right, k);
    }

    private int kthSmallestP1(TreeNode root, int k) {
        ansP1 = 0;
        kthP1 = 0;
        inOrderP1(root, k);
        return ansP1;
    }

    private void inOrderP1(TreeNode root, int k) {

        if(root == null) {
            return;
        }
        inOrderP1(root.left, k);
        kthP1 +=1;

        if(kthP1 == k) {
            ansP1 = root.val;
        }
        inOrderP1(root.right, k);
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
        System.out.println(solution.kthSmallestP1(n6, 2));
        System.out.println(solution.kthSmallest(n6, 6));
        System.out.println(solution.kthSmallestP1(n6, 6));
    }
}

/*
            6
        4       7
   3        5       8
 */