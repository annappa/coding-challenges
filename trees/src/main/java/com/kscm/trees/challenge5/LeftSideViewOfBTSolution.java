package com.kscm.trees.challenge5;

import com.kscm.trees.challenge2.MyBinaryNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
}

/*
The core idea of this algorithm:

1.Each depth of the tree only select one node.
2. View depth is current size of result list.
 */
public class LeftSideViewOfBTSolution {
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        leftView(root, res, 0);
        return res;
    }

    private void leftView(TreeNode current, List<Integer> res, int depth) {
        if(current == null) {
            return;
        }

        // At each depth, only one element can be added. depth -> 0, 1, 2, 3 .....
        // At 0th depth, result size is 0, so add the element
        // At 1st depth, result size is one(means, only one depth is traversed), add the element
        if(depth == res.size()) {
            res.add(current.val);
        }

        // traverse to the left
        leftView(current.left, res, depth+1);
        // traverse to the right, needed because if left child is not there
        leftView(current.right, res, depth+1);
    }

   /* public List<Integer> leftSideView_using_bfs(TreeNode root) {
        TreeNode currentNode;
        List<Integer> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            res.add(currentNode.());
            if(currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }

            if(currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }
        return res;
    }*/

    public List<Integer> leftSideView_another_approach(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        leftView(root, visited, res, 0);

        return res;
    }

    private void leftView(TreeNode curr, Set<Integer> visited, List<Integer> res, int depth) {
        if(curr == null) {
            return;
        }

        if(!visited.contains(depth)) {
            visited.add(depth);
            res.add(curr.val);
        }

        leftView(curr.left, visited, res, depth+1);
        leftView(curr.right, visited, res, depth+1);
    }

    public static void main(String[] args) {
        LeftSideViewOfBTSolution sideViewOfBTSolution = new LeftSideViewOfBTSolution();
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2, null, n5);
        TreeNode n3 = new TreeNode(3, null, n4);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(sideViewOfBTSolution.leftSideView(n1));

        System.out.println("--- Using Another approach -----");
        System.out.println(sideViewOfBTSolution.leftSideView_another_approach(n1));
    }
}

/*
            1
       2        3
            5       4
 */
