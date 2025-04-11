package com.kscm.trees.challenge2;

public class BSTValidationP1 {
    public static void main(String[] args) {
        BSTValidationP1 bstValidationP1 = new BSTValidationP1();
        MyBinarySearchTree tree = new MyBinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(21);
        tree.insert(1);
        tree.insert(6);
        tree.insert(15);
        tree.insert(170);
        tree.printTree();
        //tree.remove(20);
        //tree.remove(4);
        tree.printTree();
        tree.insert(20);
        tree.insert(18);
        tree.insert(10);
        tree.printTree();
        //tree.remove(170);
        tree.printTree();
        //           9
        //      4         21
        //    1   6   15       170
        //          10   20
        //             18
        System.out.println(bstValidationP1.isValidBST(tree.getRoot()));
    }

    private boolean isValidBST(MyBinaryNode root) {
        //low and high values are being passed as null(Objects) for root so that comparision will be skipped , no need to test at root
        return isValid(root, null, null);
    }

    private boolean isValid(MyBinaryNode node, Integer low, Integer high) {
        if(node == null)
            return true;

        //low and high values are being passed as null(Objects) for root so that comparision will be skipped , no need to test at root
        if(( low != null && node.getValue() <= low) || ( high!= null && node.getValue() >= high)) {
            return false;
        }

        return isValid(node.getLeft(), low, node.getValue()) && isValid(node.getRight(), node.getValue(), high );
    }
}
