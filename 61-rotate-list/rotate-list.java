/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Handle edge cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Calculate the length of the list
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Make the list circular
        current.next = head;

        // Calculate the effective number of rotations
        k = k % length;
        if (k == 0) {
            current.next = null; // Break the circular link
            return head;
        }

        // Find the new tail: length - k - 1
        int newTailIndex = length - k - 1;
        ListNode newTail = head;
        for (int i = 0; i < newTailIndex; i++) {
            newTail = newTail.next;
        }

        // The new head is the next of the new tail
        ListNode newHead = newTail.next;

        // Break the circular link
        newTail.next = null;

        return newHead;
    }
}