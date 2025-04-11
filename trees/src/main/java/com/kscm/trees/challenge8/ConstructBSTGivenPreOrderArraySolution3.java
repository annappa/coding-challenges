package com.kscm.trees.challenge8;

public class ConstructBSTGivenPreOrderArraySolution3 {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        //Since pre-order is given, first element will be the root
        for(int elem : preorder) {
            root = buildBST(root , elem);
        }
        return root;
    }

    private TreeNode buildBST(TreeNode root, int elem) {
        //First time creates the root node
        if(root == null) {
            return new TreeNode(elem);
        }

        //if element value is less, then it should go to left as BST rule
        if(elem < root.val) {
            root.left = buildBST(root.left, elem);
        } else {
            root.right = buildBST(root.right, elem);
        }

        return root;
    }

    private TreeNode bstFromPreorderP1(int[] arr) {
        TreeNode root = null;

        for(int i=0; i<arr.length; i++) {
            root = buildBSTP1(root, arr[i]);
        }

        return root;
    }

    private TreeNode buildBSTP1(TreeNode root, int elem) {
        if(root == null)
            return new TreeNode(elem);

        if(elem < root.val) {
            root.left = buildBSTP1(root.left, elem);
        } else {
            root.right = buildBSTP1(root.right, elem);
        }

        return root;
    }

    public static void main(String[] args) {
        ConstructBSTGivenPreOrderArraySolution3 constructBSTGivenPreOrderArraySolution = new ConstructBSTGivenPreOrderArraySolution3();
        int[] arr = new int[]{8,5,1,7,10,12};
        System.out.println(constructBSTGivenPreOrderArraySolution.bstFromPreorder(arr));
        System.out.println(constructBSTGivenPreOrderArraySolution.bstFromPreorderP1(arr));
    }
}
