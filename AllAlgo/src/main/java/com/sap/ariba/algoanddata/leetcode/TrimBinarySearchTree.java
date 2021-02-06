package com.sap.ariba.algoanddata.leetcode;

/**
 * Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.
 * <p>
 * Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,0,2], low = 1, high = 2
 * Output: [1,null,2]
 * <p>
 * Input: root = [1], low = 1, high = 2
 * Output: [1]
 * <p>
 * Input: root = [1,null,2], low = 2, high = 4
 * Output: [2]
 */
public class TrimBinarySearchTree {

    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null) {
            return root;
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}

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