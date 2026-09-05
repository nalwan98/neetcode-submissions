class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap= new PriorityQueue<>();
        for(int i: nums){
            if(minHeap.size()==k && minHeap.peek()>i){

            }
            else{
                if(minHeap.size()==k){
                    minHeap.remove();
                }
                minHeap.add(i);
            }
        }
    }
    
    public int add(int val) {
        if(minHeap.size()==k && minHeap.peek()>val){
        }
        else{
            if(minHeap.size()==k){
                minHeap.remove();
            }
            minHeap.add(val);
        }
        return minHeap.peek();
    }
}
