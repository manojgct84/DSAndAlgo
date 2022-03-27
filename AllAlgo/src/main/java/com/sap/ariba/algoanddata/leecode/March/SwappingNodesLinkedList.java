package com.sap.ariba.algoanddata.leecode.March;

public class SwappingNodesLinkedList {

    /**
     * You are given the head of a linked list, and an integer k.
     * <p>
     * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [1,4,3,2,5]
     * Example 2:
     * <p>
     * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
     * Output: [7,9,6,6,8,7,3,0,9,5]
     * Example 3:
     * <p>
     * Input: head = [1], k = 1
     * Output: [1]
     * Example 4:
     * <p>
     * Input: head = [1,2], k = 1
     * Output: [2,1]
     * Example 5:
     * <p>
     * Input: head = [1,2,3], k = 2
     * Output: [1,2,3]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the list is n.
     * 1 <= k <= n <= 105
     * 0 <= Node.val <= 100
     */

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head, second = head, third = head;
        while (--k > 0) {
            first = first.next;
            second = second.next;
        }
        while (first.next != null) {
            first = first.next;
            third = third.next;
        }
        int t = second.val;
        second.val = third.val;
        third.val = t;
        return head;
    }
}
