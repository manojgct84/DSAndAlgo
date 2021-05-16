package com.ariba.sap.test.leecode.April;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 * Example 2:
 * <p>
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 19
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 100
 */

public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = 0;
        while (!q.isEmpty()) {
            ans = 0;
            int sz = q.size();
            for (int i = 0; i < sz; ++i) {
                TreeNode cur = q.poll();
                assert cur != null;
                ans += cur.val;
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
        return ans;
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
