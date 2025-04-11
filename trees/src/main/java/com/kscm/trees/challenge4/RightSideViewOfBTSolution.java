package com.kscm.trees.challenge4;

import java.util.ArrayList;
import java.util.List;

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
public class RightSideViewOfBTSolution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }

    private static List<Integer> rightSideViewP1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightViewP1(root, res, 0);
        return res;
    }

    private static void rightViewP1(TreeNode root, List<Integer> res, int depth) {
        if(root == null)
            return;

        if(depth == res.size())
            res.add(root.val);

        rightViewP1(root.right, res, depth+1);
        rightViewP1(root.left, res, depth+1);
    }

    public static void main(String[] args) {
        RightSideViewOfBTSolution sideViewOfBTSolution = new RightSideViewOfBTSolution();
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        //TreeNode n2 = new TreeNode(2, n5, null);
        TreeNode n2 = new TreeNode(2, null, n5);
        //TreeNode n3 = new TreeNode(3, null, null);
        //TreeNode n3 = new TreeNode(3, null, n4);
        TreeNode n3 = new TreeNode(3, n4, null);
        TreeNode n1 = new TreeNode(1, n2, n3);

        //System.out.println(sideViewOfBTSolution.rightSideView(n1));
        System.out.println(sideViewOfBTSolution.rightSideViewP1(n1));
    }
}

/*
            1
       2        3
            5       4
 */
