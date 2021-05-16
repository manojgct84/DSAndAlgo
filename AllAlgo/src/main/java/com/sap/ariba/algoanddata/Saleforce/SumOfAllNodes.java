package com.ariba.sap.Saleforce;

public class SumOfAllNodes {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sumOfAllNode(root));
    }

    private static int sumOfAllNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return (node.val + (sumOfAllNode(node.left) + sumOfAllNode(node.right)));
    }
}
