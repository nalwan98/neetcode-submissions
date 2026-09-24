class LRUCache {

    Map<Integer, ListNode> map;
    int capacity;
    ListNode last = null;
    ListNode first=null;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity=capacity;
        last = new ListNode(0,0);
        first = new ListNode(0,0);
        first.next=last;
        last.prev = first;
    }
    
    public int get(int key) {
        //
        if(map.containsKey(key)){
            ListNode cur = map.get(key);
            remove(cur);
            putlast(cur);
            return cur.val;
        }
        return -1;
    }

    public void remove(ListNode node){
        ListNode prev = node.prev;
        ListNode next = node.next;

        prev.next=next;
        next.prev=prev;
        node.next=null;
        node.prev=null;
    }

    public void putlast(ListNode node){
        node.prev = last.prev;
        last.prev.next=node;
        last.prev = node;
        node.next=last;
    }
    public void put(int key, int value) {
        ListNode cur = null;
        if(!map.containsKey(key)){
            cur = new ListNode(value, key);
            putlast(cur);
            map.put(key, cur);
        }
        else{
            cur = map.get(key);
            remove(cur);
            putlast(cur);
            cur.val=value;
        }
        
        if(capacity<map.size()){
            map.remove(first.next.key);
            remove(first.next);
        }
    }
}

class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int val, int key){
        this.val=val;
        this.key=key;
    }
}
