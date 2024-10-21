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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Check if there are at least k nodes left in the list
        ListNode current = head;
        int count = 0;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }
        
        // If we have k nodes, then we reverse them
        if (count == k) {
            // Reverse k nodes
            ListNode prev = null;
            ListNode next = null;
            current = head;
            for (int i = 0; i < k; i++) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            // head is now the last node in the reversed group,
            // so link it to the result of the next k-group reversal
            if (next != null) {
                head.next = reverseKGroup(next, k);
            }
            // prev is the new head of the reversed group
            return prev;
        }
        // If we don't have k nodes, return head as it is
        return head;
    }
}