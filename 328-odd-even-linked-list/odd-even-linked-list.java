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
    public ListNode oddEvenList(ListNode head) {

       if(head == null || head.next == null){
        return head;
       }


       ListNode odd = head;
       ListNode even = head.next;
       ListNode evenHead = even;  // We'll need to connect the end of odd list to even list
        
    
        while(even != null && even.next !=null){
          odd.next = even.next; // Link current odd node to the next odd node
          odd = odd.next; // Move odd pointer
          even.next = odd.next; // Link current even node to the next even node
          even = even.next; // Move even pointer
        }
// Connect the end of odd list to the start of the even list
       odd.next = evenHead;
        
        return head;
    }
}