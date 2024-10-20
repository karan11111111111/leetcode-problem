/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
   
    public void deleteNode(ListNode node) {
//overwrite data of next node on current node
    node.val = node.next.val;
//make current node point to next of next node    
    node.next = node.next.next;
    }
}