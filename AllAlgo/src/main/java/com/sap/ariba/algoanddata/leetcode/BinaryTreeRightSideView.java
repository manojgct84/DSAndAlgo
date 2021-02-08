package com.sap.ariba.algoanddata.leetcode;

import java.util.*;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * <p>
 * ex : 1
 * /
 * 2
 * Ouput : [1]
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                int qSize = q.size();
                for (int i = 0; i < qSize; i++) {
                    TreeNode r = q.poll();
                    if (i == 0) {
                        result.add(r.val);
                    }
                    if (r != null) {
                        if (r.right != null) {
                            q.add(r.right);
                        }
                        if (r.left != null) {
                            q.add(r.left);
                        }
                    }
                }
            }
        }
        return result;
    }
}

/*class TreeNode {
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
}*/
