package com.sap.ariba.algoanddata.Saleforce;

public class MirrorBT {


    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);

        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(2);
        b.right = new TreeNode(3);

        System.out.println(mirrorBT(a));
        System.out.println(checkMirrorBT(a, b));
        System.out.println(heightOfBT(a));
    }

    private static TreeNode mirrorBT(TreeNode root) {

        if (root == null) {
            return root;
        }

        TreeNode left = mirrorBT(root.left);
        TreeNode right = mirrorBT(root.right);

        root.left = right;
        root.right = left;
        return root;
    }


    private static boolean checkMirrorBT(TreeNode a, TreeNode b) {

        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.val != b.val) return false;

        return checkMirrorBT(a.left, b.right) &&
                checkMirrorBT(a.right, b.left);
    }

    private static int heightOfBT(TreeNode a) {

        if (a == null)
            return 0;
        else {
            int lefT = heightOfBT(a.left);
            int rigtT = heightOfBT(a.right);

            if (lefT > rigtT) {
                return lefT + 1;
            } else
                return rigtT + 1;
        }
    }

}
