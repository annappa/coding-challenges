package com.kscm.trees.challenge8;

public class ConstructBSTGivenPreOrderArraySolution2 {
    int i = 0;
    public TreeNode bstFromPreorder(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    /*
    The official solution uses lower and upper bound while this solution uses only one bound, i.e. the upper bound.
    It's possible to do this because when you construct the left child the upper bound will be the node value itself and no lower bound will be needed;
    when you construct the right child the upper bound will be the node value itself.

    Why right child lower bound is not needed?
        Because you come to the point to construct the right child after this element failed the requirement of becoming left element of the current node!
     */
    public TreeNode bstFromPreorder(int[] preOrderArr, int bound) {
        //processed all the elements
        if (i == preOrderArr.length)
            return null;

        // For left, bound will be root value. Element can not go beyond bound value
        // For right, bound
        if(preOrderArr[i] > bound)
            return null;

        TreeNode root = new TreeNode(preOrderArr[i++]);

        root.left = bstFromPreorder(preOrderArr, root.val);
        root.right = bstFromPreorder(preOrderArr, bound);

        return root;
    }

    public static void main(String[] args) {
        ConstructBSTGivenPreOrderArraySolution2 constructBSTGivenPreOrderArraySolution = new ConstructBSTGivenPreOrderArraySolution2();
        int[] arr = new int[]{8,5,1,7,10,12};
        System.out.println(constructBSTGivenPreOrderArraySolution.bstFromPreorder(arr));
    }
}
