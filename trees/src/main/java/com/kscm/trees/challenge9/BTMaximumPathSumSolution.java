package com.kscm.trees.challenge9;

public class BTMaximumPathSumSolution {
    int maxPathSum=Integer.MIN_VALUE;

    /*
    The question can be solved by small modification to program of Height of tree.
    The idea is quite simple.
    path sum (leftSubtree)+  path sum(rightSubtree) (at any node ) is the max path sum.
    Keep track of maxium path sum duing traversal and find the path sum of the tree.

    maxPathSum=max(maxPathSum,leftPathSum+rightPathSum); => This line maintains the max path sum.
     */
    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxPathSum;
    }
    private int maxPathDown(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftPathSum = Math.max(0, maxPathDown(node.left));
        int rightPathSum = Math.max(0,maxPathDown(node.right));

        maxPathSum = Math.max(maxPathSum, leftPathSum + rightPathSum + node.val);

        return Math.max(leftPathSum, rightPathSum) + node.val;
    }

    public static void main(String[] args) {
        BTMaximumPathSumSolution btMaximumPathSumSolution = new BTMaximumPathSumSolution();
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1, n2, n3);

        //System.out.println(btMaximumPathSumSolution.maxPathSum(n1));

        TreeNode t2n1 = new TreeNode(-3);
        System.out.println(btMaximumPathSumSolution.maxPathSum(t2n1));
    }
}

/*
        1
    2       3
 */

/*
            -10
       9              20
                15          7
 */