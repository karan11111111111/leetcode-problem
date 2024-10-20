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

      if(head == null || head.next == null){
        return null;
      }
      ListNode temp = head;
      int size =0;
      while(temp != null){
        size++;
        temp =  temp.next;
      }
       // from start  
      int nth = size - n;
     

      if(nth == 0){
        return head.next;
      }


     ListNode prev =  head;
     for(int i=1; i<nth; i++){
        prev = prev.next;
     }

     prev.next =  prev.next.next;


     return head;
        
    }
}