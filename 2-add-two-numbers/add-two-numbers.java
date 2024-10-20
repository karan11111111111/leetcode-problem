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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy head for the result list
        ListNode current = dummyHead; // Pointer for the current node in the result list
        int carry = 0; // Initialize carry to 0

        // Traverse both lists
        while (l1 != null || l2 != null) {
            int sum = carry; // Start with the carry

            // Add the value of l1 if available
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next; // Move to the next node in l1
            }

            // Add the value of l2 if available
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next; // Move to the next node in l2
            }

            // Update carry and create a new node for the current digit
            carry = sum / 10; // Calculate the new carry
            current.next = new ListNode(sum % 10); // Create a new node with the digit
            current = current.next; // Move to the next node in the result list
        }

        // If there's a carry left after the last addition, add it as a new node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        // Return the next of dummy head which points to the actual result
        return dummyHead.next;
    }
}
