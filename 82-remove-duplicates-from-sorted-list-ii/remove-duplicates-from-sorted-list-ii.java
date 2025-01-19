class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node to handle edge cases where the head itself is removed
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy; // Points to the last distinct node
        ListNode current = head;

        while (current != null) {
            // Check if the current node has duplicates
            if (current.next != null && current.val == current.next.val) {
                // Skip all nodes with the same value
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                // Remove the entire duplicate group
                prev.next = current.next;
            } else {
                // No duplicates, move prev forward
                prev = current;
            }
            current = current.next; // Move to the next node
        }

        return dummy.next; // Return the updated list, skipping the dummy node
    }
}
