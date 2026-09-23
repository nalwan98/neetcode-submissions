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
        ListNode iterate = head;
        int totallength=0;
        while(iterate!=null){
            totallength++;
            iterate = iterate.next;
        }
        int nfromstart = totallength-n;
        ListNode res = head;
        if(nfromstart==0){
            return res.next;
        }
        for(int i=0; i<=nfromstart; i++){
            if(i==nfromstart-1){
                if(head.next!=null){
                    head.next = head.next.next;
                }
            }
            if(head!=null){
                head= head.next;
            }
            
        }
        return res;
    }
}
