package com.sap.ariba.algoanddata.leecode.March;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given the root of a binary tree with n nodes, where each node is uniquely assigned a value from 1 to n.
 * You are also given a sequence of n values voyage, which is the desired pre-order traversal of the binary tree.
 * <p>
 * Any node in the binary tree can be flipped by swapping its left and right subtrees.
 * For example, flipping node 1 will have the following effect:
 * <p>
 * <p>
 * Flip the smallest number of nodes so that the pre-order traversal of the tree matches voyage.
 * <p>
 * Return a list of the values of all flipped nodes. You may return the answer in any order.
 * If it is impossible to flip the nodes in the tree to make the pre-order traversal match voyage, return the list [-1].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2], voyage = [2,1]
 * Output: [-1]
 * Explanation: It is impossible to flip the nodes such that the pre-order traversal matches voyage.
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2,3], voyage = [1,3,2]
 * Output: [1]
 * Explanation: Flipping node 1 swaps nodes 2 and 3, so the pre-order traversal matches voyage.
 * Example 3:
 * <p>
 * <p>
 * Input: root = [1,2,3], voyage = [1,2,3]
 * Output: []
 * Explanation: The tree's pre-order traversal already matches voyage, so no nodes need to be flipped.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is n.
 * n == voyage.length
 * 1 <= n <= 100
 * 1 <= Node.val, voyage[i] <= n
 * All the values in the tree are unique.
 * All the values in voyage are unique.
 */

public class FlipBinaryTreeToMatchPreorderTraversal {

    List<Integer> res = new ArrayList<>();
    int i = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return dfs(root, voyage) ? res : Arrays.asList(-1);
    }

    private boolean dfs(TreeNode root, int[] voyage) {
        if (root == null) {
            return true;
        }

        if (root.val != voyage[i]) {
            return false;
        }
        i++;
        if (root.left != null && root.left.val != voyage[i]) {
            res.add(root.val);
            return dfs(root.right, voyage) && dfs(root.left, voyage);
        }
        return dfs(root.left, voyage) && dfs(root.right, voyage);
    }
}
