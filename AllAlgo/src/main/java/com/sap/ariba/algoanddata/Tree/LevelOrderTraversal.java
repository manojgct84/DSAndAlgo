package com.sap.ariba.algoanddata.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal
{
    public static class Node
    {
        int data;
        LevelOrderTraversal.Node left;
        LevelOrderTraversal.Node right;

        public Node (int data)
        {

            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public LevelOrderTraversal.Node root;

    public void topView (Node root)
    {
        Queue topViewQ = new LinkedList();
        if (root == null) {
            System.out.println("root is null");
        }

        topViewQ.add(root);          //    1
                                    //   2     3
                                    // 4     4    5

        while (!topViewQ.isEmpty()) {
            Node temp = (Node)topViewQ.poll();
            System.out.print(temp.data);
            System.out.print(" ");

            //if (topViewQ.isEmpty()) {
                if (temp.left != null) {
                    topViewQ.add(temp.left);
                }
                if (temp.right != null) {
                    topViewQ.add(temp.right);
                }

            //}

        }
    }
    public static void main(String[] args) {

        LevelOrderTraversal lot = new LevelOrderTraversal();
        //Add nodes to the binary tree
        lot.root = new LevelOrderTraversal.Node(1);
        lot.root.left = new LevelOrderTraversal.Node(2);
        lot.root.right = new LevelOrderTraversal.Node(3);
        lot.root.left.left = new LevelOrderTraversal.Node(4);
        lot.root.right.left = new LevelOrderTraversal.Node(5);
        lot.root.right.right = new LevelOrderTraversal.Node(6);
        lot.root.right.right.right= new LevelOrderTraversal.Node(7);
        lot.root.right.right.right.right = new LevelOrderTraversal.Node(8);

        System.out.println("Level Order Travesal binary tree: " );
                         lot.topView(lot.root);
    }
}
