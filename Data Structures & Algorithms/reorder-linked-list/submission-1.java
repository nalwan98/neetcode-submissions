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
    public void reorderList(ListNode head) {
        //find mid point and get that list
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        //reverse the list starting from midpoint
        ListNode prev = null;
        ListNode reversed = prev;
        while(second!=null){
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        //merge the two lists
        head = mergeTwoLists(head,prev);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode moving = new ListNode();
        ListNode res = moving;
        int l=1;
        while(list1!=null && list2!=null){
            if(l==1){
                moving.next = list1;
                list1=list1.next;
                l=2;
            }
            else{
                moving.next = list2;
                list2=list2.next;
                l=1;
            }

            moving = moving.next;
        }
        if(list1!=null){
            moving.next = list1;
        }
        if(list2!=null){
            moving.next = list2;
        }
        return res.next;
    }
}
