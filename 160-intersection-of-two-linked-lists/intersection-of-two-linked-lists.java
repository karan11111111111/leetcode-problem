/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         if(headA == null || headB == null) return null;
//         ListNode a = headA;
//         ListNode b = headB;

//         while( a != b){
//             a = a == null? headB : a.next;
//             b = b == null? headA : b.next;    
//         }
//         return a;
//     }

    
// }

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        HashMap<ListNode,Integer> mpp=new HashMap<>();
        ListNode first=headA;
        ListNode second=headB;
        while(first!=null){
            mpp.put(first,mpp.getOrDefault(first,0)+1);
            first=first.next;
            }
        while(second!=null){
            if(mpp.containsKey(second)){ //if duplicate return the duplicate one
                return second;
            }
            second=second.next;
        }
        return null;
        
    }
}