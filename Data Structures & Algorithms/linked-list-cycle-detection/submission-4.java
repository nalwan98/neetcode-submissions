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
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode fast = head;
        ListNode faster = head.next;
    
        while(faster!=null && faster.next!=null){
            if(fast==faster){
                return true;
            }
            fast = fast.next;
            faster = faster.next.next;
        }
        return false;
    }
}
