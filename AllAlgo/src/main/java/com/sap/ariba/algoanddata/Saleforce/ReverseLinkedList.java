package com.ariba.sap.Saleforce;

public class ReverseLinkedList {

    static Node head;

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        System.out.println(revers(node).toString());
    }

    private static Node revers(Node node) {
        head = node;
        Node current = head;
        Node prev = null;

        while (current != null) {
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}