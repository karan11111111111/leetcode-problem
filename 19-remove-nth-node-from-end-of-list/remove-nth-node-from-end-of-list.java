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
    public ListNode removeNthFromEnd(ListNode head, int n) {

    //   if(head == null || head.next == null){
    //     return null;
    //   }
    //   ListNode temp = head;
    //   int size =0;
    //   while(temp != null){
    //     size++;
    //     temp =  temp.next;
    //   }
    //    // from start  
    //   int nth = size - n;
     

    //   if(nth == 0){
    //     return head.next;
    //   }


    //  ListNode prev =  head;
    //  for(int i=1; i<nth; i++){
    //     prev = prev.next;
    //  }

    //  prev.next =  prev.next.next;


    //  return head;



// two  pointer approach
 
        if (head == null) {
            return null;
        }

        // Create a dummy node to handle edge cases, like removing the first node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize two pointers both at the dummy node
        ListNode first = dummy;
        ListNode second = dummy;

        // Move the first pointer n+1 steps ahead so the gap between first and second is n nodes
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Now move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // The second pointer is at the node just before the one to be deleted
        second.next = second.next.next;

        // Return the new head (dummy.next in case the head was removed)
        return dummy.next;
    
        
    }
}