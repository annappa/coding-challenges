package com.kscm.trees.challenge7;

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

public class DiameterOfABTSolution {
    int diameter=0;
    int diameterP1=0;

    /*
    The question can be solved by small modification to program of Height of tree.
    The idea is quite simple.
    Max value of Height(leftSubtree)+Height(rightSubtree) (at any node ) is the diameter.
    Keep track of maxium diameter duing traversal and find the height of the tree.

    diameter=max(diameter,leftDiameter+rightDiameter); => This line maintains the max diameter.
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }

    private int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        //Keep going to the left unless the child node is null, then return 0
        int leftDiameter = maxDepth(root.left);
        //Keep going to the right unless the child node is null, then return 0
        int rightDiameter = maxDepth(root.right);

        //Max value of Height(leftSubtree)+Height(rightSubtree) (at any node ) is the diameter.
        diameter = Math.max(diameter, leftDiameter + rightDiameter);

        return Math.max(leftDiameter, rightDiameter) + 1;
    }

    private int diameterOfBinaryTreeP1(TreeNode root) {
        maxDepthP1(root);
        return diameterP1;
    }

    private int maxDepthP1(TreeNode root) {
        if(root == null)
            return 0;

        int leftD = maxDepth(root.left);
        int rightD = maxDepth(root.right);

        diameterP1 = Math.max(diameterP1, leftD+rightD);

        return Math.max(leftD, rightD) + 1;
    }

    public static void main(String[] args) {
        DiameterOfABTSolution diameterOfABTSolution = new DiameterOfABTSolution();
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(diameterOfABTSolution.diameterOfBinaryTree(n1));
        System.out.println(diameterOfABTSolution.diameterOfBinaryTreeP1(n1));
    }
}
