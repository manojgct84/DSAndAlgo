package com.leecode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.right = new TreeNode(9);
        treeNode.left = new TreeNode(20);
        treeNode.left.left = new TreeNode(15);
        treeNode.left.right = new TreeNode(7);
        System.out.println(averageOfLevels(treeNode));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        int level = 1;
        int val = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Double> lst = new ArrayList<>();
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.remove();
                val += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            lst.add((double) (val / level));
            val = 0;
            level++;
        }
        return lst;
    }
}
