package com.sap.ariba.algoanddata.leetcode.SRE;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        helper(root.left, result);
        result.add(root.val);
        helper(root.right,result);
    }


}

class TreeNode {
    TreeNode right = null;
    TreeNode left = null;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}