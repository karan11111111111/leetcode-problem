/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a copy of each node and insert it right after the original node
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next; // Move to the next original node
        }

        // Step 2: Set the random pointers for the copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next; // Point to the copy of the random node
            }
            curr = curr.next.next; // Move to the next original node
        }

        // Step 3: Separate the original list and the copied list
        curr = head;
        Node copiedHead = head.next; // The head of the copied list
        Node copyCurr = copiedHead;

        while (curr != null) {
            curr.next = curr.next.next; // Restore the original list
            if (copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next; // Move to the next copied node
            }
            curr = curr.next; // Move to the next original node
            copyCurr = copyCurr.next; // Move to the next copied node
        }

        return copiedHead; // Return the head of the copied list
    }
}