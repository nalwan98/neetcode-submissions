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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode p = res;
        int i =0;
        int j =0;
        int pos =0;
        int carr = 0;
        while(l1!=null && l2!=null){
           res.next =  new ListNode((l1.val + l2.val + carr) % 10);
           carr = (l1.val + l2.val + carr) / 10;
           res = res.next;
           l1 = l1.next;
           l2 = l2.next;
        }
        while(l1!=null){
            res.next = new ListNode((l1.val + carr) % 10);
            carr = (l1.val + carr) / 10;
            res = res.next;
            l1 = l1.next;
        }
        while(l2!=null){
            res.next = new ListNode((l2.val + carr) % 10);
            carr = (l2.val + carr) / 10;
            res = res.next;
            l2 = l2.next;
        }
        if(carr!=0){
            res.next = new ListNode(carr);
            res = res.next;
        }
        return p.next;

    }
}
