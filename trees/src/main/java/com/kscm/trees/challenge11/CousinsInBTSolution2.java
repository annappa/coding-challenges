package com.kscm.trees.challenge11;


public class CousinsInBTSolution2 {
    int xParent=-1;
    int yParent=-1;
    int xHeight=0;
    int yHeight=0;

    int xParentP1=-1;
    int yParentP1=-1;
    int xHeightP1=0;
    int yHeightP1=0;

    public boolean isCousins(TreeNode root, int A, int B) {
        if(root == null)
            return false;

        if(root.val == A || root.val == B) {
            return false;
        }

        find_HeightParent(root,A, B,-1, 0);

        if(xParent != yParent && xHeight == yHeight)
            return true;

        return false;
    }

    private void find_HeightParent(TreeNode curr, int x, int y, int parent, int height) {
        if(curr == null)
            return;

        // each time we traverse, parent will be the previously visited node value which was marked in the previous traverse.
        // For the first time , it will be -1 because for root, there is no parent
        if(curr.val == x) {
            xParent = parent;
            xHeight = height;
        }

        if(curr.val == y) {
            yParent = parent;
            yHeight = height;
        }

        //Traverse to the left, to find the the parent and height of x and y
        find_HeightParent(curr.left, x, y, curr.val, height+1);
        //Traverse to the right, to find the the parent and height of x or y
        find_HeightParent(curr.right, x, y, curr.val, height+1);
    }

    private boolean isCousinsP1(TreeNode root, int A, int B) {
        if(root == null) {
            return false;
        }

        if(root.val == A || root.val == B) {
            return false;
        }

        find_HeightParentP1(root, A, B, -1, 0);

        if(xParentP1 != yParentP1 && xHeight == yHeight) {
            return true;
        }
        return false;
    }

    private void find_HeightParentP1(TreeNode cN, int A, int B, int parent, int height) {
        if(cN == null) {
            return;
        }

        if(cN.val == A) {
            xParentP1 = parent;
            xHeight = height;
        }

        if(cN.val == B) {
            yParentP1 = parent;
            yHeightP1 = height;
        }

        find_HeightParentP1(cN.left, A, B, cN.val, height+1);
        find_HeightParentP1(cN.right, A, B, cN.val, height+1);
    }

    public static void main(String[] args) {
        CousinsInBTSolution2 cousinsInBTSolution = new CousinsInBTSolution2();
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, null, n6);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(cousinsInBTSolution.isCousins(n1, 4, 6));
        System.out.println(cousinsInBTSolution.isCousinsP1(n1, 4, 6));
        System.out.println(cousinsInBTSolution.isCousins(n1, 4, 5));
        System.out.println(cousinsInBTSolution.isCousinsP1(n1, 4, 5));
    }
}

/*
            1
        2       3
   4        5       6
 */
