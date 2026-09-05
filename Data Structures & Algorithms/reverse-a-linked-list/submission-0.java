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
    public ListNode reverseList(ListNode head) {
        ListNode pointer = null;

        while(head != null){
            ListNode temp = head.next;
            head.next = pointer;
            pointer = head;
            if(temp==null){
                break;
            }
            head = temp;
        }
        return head;
        
    }
}
