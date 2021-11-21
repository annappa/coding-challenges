package com.kscm.trees.challenge10;

public class ValidateSequenceTreeSolution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        int n = arr.length;
        int pos = 0;
        return isValidSequence(root,n,pos,arr);
    }

    private boolean isValidSequence(TreeNode root,int n,int pos,int[] arr)
    {
        //Reached the leaf node but not found the sequence
        if(root == null)
            return false;

        //checked for all elements in the array but not found the sequence
        if(pos == n)
            return false;

        if(root.val != arr[pos])
            return false;

        if(root.left == null && root.right == null && pos == n-1)
            return true;

        return (isValidSequence(root.left, n,pos+1, arr) || isValidSequence(root.right, n,pos+1,arr));
    }

    public static void main(String[] args) {
        ValidateSequenceTreeSolution validateSequenceTreeSolution = new ValidateSequenceTreeSolution();
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, null, n6);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(validateSequenceTreeSolution.isValidSequence(n1, new int[]{1, 2, 4}));
        System.out.println(validateSequenceTreeSolution.isValidSequence(n1, new int[]{1, 2, 4, 5}));

    }
}


/*
            1
        2       3
   4        5       6
 */