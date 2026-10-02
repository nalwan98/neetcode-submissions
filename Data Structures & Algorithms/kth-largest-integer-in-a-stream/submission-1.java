class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        for(int n: nums){
            minHeap.add(n);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        while(minHeap.size()>k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
