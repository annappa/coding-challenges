package com.kscm.trees.challenge3;

import java.util.*;

class TreeNodeP1 {
    int val;
    TreeNodeP1 left;
    TreeNodeP1 right;

    public TreeNodeP1() {

    }

    public TreeNodeP1(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNodeP1(int val, TreeNodeP1 left, TreeNodeP1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

public class SolutionP1 {
    public static void main(String[] args) {
        TreeNodeP1 n4 = new TreeNodeP1(4);
        TreeNodeP1 n5 = new TreeNodeP1(5);
        TreeNodeP1 n6 = new TreeNodeP1(6);
        TreeNodeP1 n7 = new TreeNodeP1(7);

        TreeNodeP1 n2 = new TreeNodeP1(2, n4, n5);
        TreeNodeP1 n3 = new TreeNodeP1(3, n6, n7);
        TreeNodeP1 n1 = new TreeNodeP1(1, n2, n3);

        int[] to_delete = {3, 5};
        System.out.println(removeAndReturnForest(n1, to_delete));
    }

    private static List<TreeNodeP1> removeAndReturnForest(TreeNodeP1 root, int[] to_delete) {
        List<TreeNodeP1> listOfRoots = new ArrayList<>();
        Set<Integer> toDeleteSet = new HashSet<>();
        for(int elem : to_delete) {
            toDeleteSet.add(elem);
        }

        removeNodes(root, listOfRoots, toDeleteSet);
        //check if the main root element needs to be deleted or not
        if(!toDeleteSet.contains(root.val)) {
            listOfRoots.add(root);
        }
        return listOfRoots;
    }

    private static TreeNodeP1 removeNodes(TreeNodeP1 root, List<TreeNodeP1> listOfRoots, Set<Integer> toDeleteSet) {
        if( root == null) {
            return null;
        }

        root.left = removeNodes(root.left, listOfRoots, toDeleteSet);
        root.right = removeNodes(root.right, listOfRoots, toDeleteSet);

        if(toDeleteSet.contains(root.val)) {
            if(root.left != null) {
                listOfRoots.add(root.left);
            }

            if(root.right != null) {
                listOfRoots.add(root.right);
            }
            return null;
        }
        return root;
    }
}
