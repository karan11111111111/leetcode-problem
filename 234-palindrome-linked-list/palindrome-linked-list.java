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
  // finding mid
    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; //mid;
    }
    public boolean isPalindrome(ListNode head) {
        
     if(head == null || head.next == null){
        return true;

     }
       //find mid node
     ListNode midNode = findMid(head);

     // reverse half node;
     ListNode prev = null;
     ListNode curr = midNode;
     ListNode next;
     
     while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
     }
    
     //check  if 1st half = 2nd half

     ListNode right = prev;
     ListNode  left = head;

     while(right != null){
        if(right.val!= left.val){
            return false;

        }
        right = right.next;
        left = left.next;
     }



     return true;
     

     

    
    

    
}
}