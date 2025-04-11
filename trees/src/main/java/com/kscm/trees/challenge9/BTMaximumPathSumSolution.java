package com.kscm.trees.challenge9;

public class BTMaximumPathSumSolution {
    int maxPathSum=Integer.MIN_VALUE;
    int maxPathSum1=Integer.MIN_VALUE;

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

    private int maxPathSumP1(TreeNode root) {
        maxPathDownP1(root);
        return maxPathSum1;
    }

    private int maxPathDownP1(TreeNode root) {
        if(root == null)
            return 0;

        //Negative value should not be considered in the path, so max of 0
        int leftSum = Math.max(0, maxPathDownP1(root.left));
        //int leftSum = maxPathDownP1(root.left);
        //Negative value should not be considered in the path, so max of 0
        int rightSum = Math.max(0, maxPathDownP1(root.right));
        //int rightSum = maxPathDownP1(root.right);

        maxPathSum1 = Math.max(maxPathSum1, leftSum+rightSum + root.val);

        return Math.max(leftSum, rightSum) + root.val;
    }

    public static void main(String[] args) {
        BTMaximumPathSumSolution btMaximumPathSumSolution = new BTMaximumPathSumSolution();
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1, n2, n3);

        //commented because there is only one global variable for sum
        //System.out.println(btMaximumPathSumSolution.maxPathSum(n1));

        TreeNode t2n1 = new TreeNode(-3);
        System.out.println(btMaximumPathSumSolution.maxPathSum(t2n1));
        System.out.println(btMaximumPathSumSolution.maxPathSumP1(t2n1));

        TreeNode t3n1 = new TreeNode(2);
        TreeNode t3n2 = new TreeNode(-1, t3n1, null);
        //Negative value should not be considered in the path
        System.out.println(btMaximumPathSumSolution.maxPathSum(t3n2));
        System.out.println(btMaximumPathSumSolution.maxPathSumP1(t3n2));
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