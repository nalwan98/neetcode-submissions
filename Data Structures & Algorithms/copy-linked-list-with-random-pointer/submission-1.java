/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node res = head;
        while(head!=null){
                Node copy =null;
                Node copynext=null;
                Node copyrandom = null;
            if(!map.containsKey(head)){
                copy = new Node(head.val);
                map.put(head, copy);
            }
            else{
                copy = map.get(head);
            }
            if(head.next==null){

            }
            else if(!map.containsKey(head.next)){
                copynext = new Node(head.next.val);
                map.put(head.next, copynext);
            }
            else{
                copynext = map.get(head.next);
            }
            if(head.random==null){

            }
            else if(!map.containsKey(head.random)){
                copyrandom = new Node(head.random.val);
                map.put(head.random, copyrandom);

            }
            else{
                copyrandom = map.get(head.random);
            }
            copy.next=copynext;
            copy.random=copyrandom;
            head = head.next;
        }
        return map.get(res);
    }
}
