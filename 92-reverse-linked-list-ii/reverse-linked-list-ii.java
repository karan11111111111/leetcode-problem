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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Edge case: if there's nothing to reverse
        if (head == null || left == right) {
            return head;
        }

        // Dummy node to simplify edge cases (like reversing from the first node)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: Reach the node before the `left` position
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Start reversing from `left` to `right`
        ListNode current = prev.next; // This is the `left` node
        ListNode next = null; // To temporarily store the next node during reversal
        ListNode prevSectionTail = prev; // To reconnect the reversed section

        for (int i = 0; i < right - left + 1; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Step 3: Reconnect the reversed section
        prevSectionTail.next.next = current; // Reconnect the tail of the reversed section
        prevSectionTail.next = prev; // Reconnect the head of the reversed section

        // Step 4: Return the updated head
        return dummy.next;
    }
}
