package com.kscm.trees.challenge3;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class Solution {
    /*Set<Integer> to_delete_set;
    List<TreeNode> res;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        to_delete_set = new HashSet<>();
        res = new ArrayList<>();

        for (int i : to_delete)
            to_delete_set.add(i);

        helper(root, true);

        return res;
    }

    private TreeNode helper(TreeNode node, boolean is_root) {
        if (node == null)
            return null;

        boolean deleted = to_delete_set.contains(node.val);

        if (is_root && !deleted)
            res.add(node);

        node.left = helper(node.left, deleted);
        node.right =  helper(node.right, deleted);

        return deleted ? null : node;
    }*/

    // Time: O(n)
    //Space: O(n)
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> remaining = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();
        for(int i: to_delete) {
            toDelete.add(i);
        }

        removeNodes(root, toDelete, remaining);

        //check if the main root element needs to be deleted or not
        if(!toDelete.contains(root.val)) {
            remaining.add(root);
        }

        return remaining;
    }

    //DFS
    private TreeNode removeNodes(TreeNode root, Set<Integer> toDelete, List<TreeNode> remaining) {
        //Reached end of the tree
        if(root == null) {
            return null;
        }

        //Keep going to left
        //After removing the node, we need to assign null to root.left
        root.left = removeNodes(root.left, toDelete, remaining);
        //Keep going to right
        //After removing the node, we need to assign null to root.left
        root.right = removeNodes(root.right, toDelete, remaining);

        //When we are at some node and it that value needs to be deleted
        if(toDelete.contains(root.val)) {
            //check if the left of that node is not all, then we need to retain that node
            if(root.left != null) {
                remaining.add(root.left);
            }

            //check if the right of that node is not all, then we need to retain that node
            if(root.right != null) {
                remaining.add(root.right);
            }

            // if not the above 2 cases, anyhow, we have make this node null.
            return null;
        }

        return root;
    }


    public static void main(String[] args) {
        //Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
        //Output: [[1,2,null,4],[6],[7]]
        Solution solution = new Solution();

        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n6, n7);
        /*
                              1
                        2          3
                    4      5    6      7
         */

        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(solution.delNodes(n1, new int[]{3,5}));
    }
}

/*
                1
         2             3
   4          5    6       7
*/