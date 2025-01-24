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
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Define a priority queue (min-heap) for ListNode
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Initialize the heap with the head of each list
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        
        // Dummy node to simplify result handling
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Extract the minimum node and build the merged list
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();  // Extract the node with the smallest value
            current.next = minNode;        // Add it to the merged list
            current = current.next;       // Move the current pointer
            
            // If the extracted node has a next node, add it to the heap
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        
        return dummy.next;  // Return the merged list starting from the next of dummy node
    }
}
