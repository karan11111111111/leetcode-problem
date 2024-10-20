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
    // private int findMid(ListNode head){
    //     ListNode slow = head;
    //     ListNode fast = head;
    //    int count = 0;
    //     while(fast != null && fast.next !=null){
    //         slow = slow.next;
    //         fast = fast.next.next;
    //         count++;
    //     }

    //     return count;

    // }


    public ListNode deleteMiddle(ListNode head) {

        // if(head ==null || head.next ==null){
        //     return null;
        // }
        
    //     int mid = findMid(head);
        
    //     ListNode temp = head;

    //     for(int i=0; i<mid-1; i++){
    //         temp = temp.next;
    //     }

    //     temp.next =  temp.next.next;

    //   return head;

    // optimised code

     if (head.next == null||head==null)
            return null;
        ListNode fast = head.next.next;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow.next = slow.next.next;
        return head;

    }
}