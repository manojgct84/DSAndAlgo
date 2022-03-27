package com.sap.ariba.algoanddata.Saleforce;

public class SumOfGrandParentEven {

    static int totalSum = 0;

    private static void getEvenGrandParentNodeSum(TreeNode node, TreeNode parent, TreeNode grandParent) {
        if (node == null)
            return;

        getEvenGrandParentNodeSum(node.left, node, parent);
        getEvenGrandParentNodeSum(node.right, node, parent);

        if (parent == null || grandParent == null) {
            return;
        }
        if (grandParent.val % 2 == 0) {
            totalSum += node.val;
        }
    }

    private static void getEvenGrandParentNodeSum(TreeNode root) {
        getEvenGrandParentNodeSum(root, null, null);
    }
}

class TreeNode {
    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}