package com.sap.ariba.algoanddata.Tree;


import java.util.Stack;

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
        System.out.println(binarySearch(new int[]{10, 20, 22, 45, 55, 70, 80}, 70));
        preOrder(a);
        preOrderWithoutRecursion(a);
        inOrder(a);
        inOrderWithoutRecursion(a);
        postOrder(a);
        postOderWithoutRecursion(a);
        isLeafNode(a);
        isLeafNodeCount(a);


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
            int rightT = heightOfBT(a.right);

            return (Math.max(lefT, rightT)) + 1;
        }
    }


    private static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length;

        while (low <= high) {
            int mid = (high + low) / 2;

            if (key > array[mid]) {
                low = mid + 1;
            } else if (key < array[mid]) {
                high = mid - 1;
            } else {
                return mid + 1;
            }
        }
        return -1;
    }

    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.printf("data value ::%s \n", root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void preOrderWithoutRecursion(TreeNode root) {
        if (root == null) {
            System.out.println("no root node found...");
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.printf("data value :: %s \n", node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
    }

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.printf("in order data value ::%s \n", root.val);
        inOrder(root.right);
    }

    private static void inOrderWithoutRecursion(TreeNode root) {
        if (root == null) {
            System.out.println("no root node found...");
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.printf("inOrder data value ::%s \n", current.val);
                current = current.right;
            }
        }
    }

    private static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.printf("postOrder data value ::%s \n", root.val);
    }

    private static void postOderWithoutRecursion(TreeNode root) {
        if (root == null) {
            System.out.println("no root node found...");
        }
        Stack<TreeNode> stack_1 = new Stack<>();
        Stack<TreeNode> stack_2 = new Stack<>();
        TreeNode current = root;
        stack_1.push(current);
        while (!stack_1.isEmpty()) {
            TreeNode node = stack_1.pop();
            stack_2.push(node);
            if (node.left != null) {
                stack_1.push(node.left);
            }
            if (node.right != null) {
                stack_2.push(node.right);
            }
        }
        while (!stack_2.isEmpty()) {
            System.out.printf("postOrder value :: %s \n", stack_2.pop().val);
        }
    }

    private static void isLeafNode(TreeNode root) {
        if (root == null) {
            return;
        }

        isLeafNode(root.right);
        isLeafNode(root.left);
        if (root.right == null && root.left == null) {
            System.out.printf("is Leaf Node :: %s \n", root.val);
        }

    }

    static int count = 0;

    private static void isLeafNodeCount(TreeNode root) {

        if (root == null) {
            return;
        }

        isLeafNodeCount(root.right);
        isLeafNodeCount(root.left);
        if (root.right == null && root.left == null) {
            ++count;
        }
        System.out.printf("count :: %s \n", count);
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