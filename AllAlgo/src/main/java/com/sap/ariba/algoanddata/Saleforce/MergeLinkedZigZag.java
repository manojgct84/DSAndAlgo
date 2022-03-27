package com.sap.ariba.algoanddata.Saleforce;

public class MergeLinkedZigZag {

    static Node head;

    public static void main(String[] args) {
        Node left = new Node(1);
        left.next = new Node(2);
        left.next.next = new Node(3);

        Node right = new Node(4);
        right.next = new Node(5);
        right.next.next = new Node(6);

        mergeLinkedZigZag(left, right);
    }

    private static void mergeLinkedZigZag(Node left, Node right) {

        Node p_left = left;
        Node q_right = right;

        if (left == null) {
            System.out.println(right.toString());
        }
        if (right == null) {
            System.out.println(left.toString());
        }
/*        Node first, second = null;
        while (p_left != null && q_right != null) {
            first = p_left.next;
            second = q_right.next;

            p_left.next = second;
            q_right.next = first;

            p_left = first;
            q_right = second;

        }*/
        Node node = new Node(0);
        boolean rightLeft = false;
        Node ptr = node;
        while (left != null & right != null) {
            if (rightLeft) {
                ptr.next = new Node(right.data);
                rightLeft = false;
                right = right.next;
            } else {
                ptr.next = new Node(left.data);
                rightLeft = true;
                left = left.next;
            }
            ptr = ptr.next;
        }
        head = node.next;
        System.out.println(head.toString());
    }
}
