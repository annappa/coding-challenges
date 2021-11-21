package com.kscm.trees.challenge11;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBTSolution {
    public boolean isCousins(TreeNode root, int A, int B) {
        if (root == null)
            return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isAexist = false;
            boolean isBexist = false;

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == A)
                    isAexist = true;

                if (cur.val == B)
                    isBexist = true;

                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == A && cur.right.val == B) {
                        return false;
                    }
                    if (cur.left.val == B && cur.right.val == A) {
                        return false;
                    }
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            if (isAexist && isBexist)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CousinsInBTSolution cousinsInBTSolution = new CousinsInBTSolution();
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, null, n6);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(cousinsInBTSolution.isCousins(n1, 4, 6));
        System.out.println(cousinsInBTSolution.isCousins(n1, 4, 5));
    }
}

/*
            1
        2       3
   4        5       6
 */
