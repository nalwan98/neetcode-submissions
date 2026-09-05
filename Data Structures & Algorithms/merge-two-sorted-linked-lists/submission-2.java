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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode first = new ListNode();
        ListNode p = first;
        if(list1==null && list2==null){
            return null;
        }
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                ListNode temp = list1.next;
                first.next = list1;
                list1 = temp;
                first = first.next;
            }
            else{
                ListNode temp = list2.next;
                first.next = list2;
                list2 = temp;
                first = first.next;
            }
        }
        if(list1!=null){
            first.next = list1;
        }
        if(list2!=null){
            first.next = list2;
        }
        return p.next;
    }
}