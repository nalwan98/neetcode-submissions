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
        if (head == null || head.next == null) {
            return; // Handle empty or single-node list
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode pointer = null;
        while (slow != null) {
            ListNode temp = slow.next; // Store next node
            slow.next = pointer;       // Reverse the link
            pointer = slow;            // Move pointer to current node
            slow = temp;               // Move to the next node
        }

         // Step 3: Merge the two halves
        ListNode p1 = head;         // Pointer for the first half
        ListNode p2 = pointer;      // Pointer for the reversed second half

        while (p2 != null) {
            ListNode temp1 = p1.next; // Store next node in the first half
            ListNode temp2 = p2.next; // Store next node in the second half
            
            p1.next = p2; // Link first half to second half
            p2.next = temp1; // Link second half to the next of the first half

            p1 = temp1; // Move to the next node in the first half
            p2 = temp2; // Move to the next node in the second half
        }
         // Final step: Ensure the last node of the reordered list points to null
        if (p1 != null) {
            p1.next = null; // To avoid any cycle if there were an odd number of nodes
        }
        

    }
}
