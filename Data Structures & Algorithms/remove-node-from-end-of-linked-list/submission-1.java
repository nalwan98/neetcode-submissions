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
        ListNode p = head;
        int count = 0;
        if(head==null){
            return head;
        }
        while(p!=null){
            p= p.next;
            count++;
        }
        p=head;
        if(count-n==0){
            return head.next;
        }
        int toDelete = count-n;
        int i = 0;
        while(p!=null){
            if(i==toDelete-1){
                p.next = p.next.next;
                break;
            }
            i++;
            p = p.next;
        }
        return head;
    }
}
