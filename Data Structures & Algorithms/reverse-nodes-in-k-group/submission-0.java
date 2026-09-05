class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Check if there are at least k nodes to reverse
        ListNode current = head;
        int count = 0;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }
        
        // If we have k nodes, then we reverse them
        if (count == k) {
            // Reverse the first k nodes
            ListNode prev = null;
            ListNode next = null;
            current = head;
            for (int i = 0; i < k; i++) {
                next = current.next; // Store next node
                current.next = prev; // Reverse the link
                prev = current;      // Move prev pointer forward
                current = next;      // Move current pointer forward
            }
            
            // Now head is the end of the reversed group
            // Recursively call for the next groups of k nodes
            if (next != null) {
                head.next = reverseKGroup(next, k);
            }
            // prev is now the new head of the reversed group
            return prev;
        }
        
        // If we don't have k nodes, return head as is
        return head;
    }
}
