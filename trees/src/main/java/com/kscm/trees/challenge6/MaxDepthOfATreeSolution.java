package com.kscm.trees.challenge6;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaxDepthOfATreeSolution {
    //if the node does not exist, simply return 0. Otherwise, return the 1 + the longer distance of its subtree.
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        //keep going to left, unless child is null, then depth calculation starts 0+1+1+....
        int left = maxDepth(root.left);
        //keep going to right, unless child is null, then depth calculation starts 0+1+1+....
        int right = maxDepth(root.right);

        // once it reached leaf node, max(0,0) + 1 for the node
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        MaxDepthOfATreeSolution solution = new MaxDepthOfATreeSolution();
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20, n15, n7);
        TreeNode n3 = new TreeNode(3, n9, n20);

        System.out.println(solution.maxDepth(n3));
    }
}
/*
            3
      9             20
                15      7
 */
