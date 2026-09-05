class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: nums){
            maxHeap.offer(i);
        }
        int res = 0;
        int i = 1;
        while(true){
            if(i==k){
                res = maxHeap.poll();
                return res;
            }
            i++;
            maxHeap.poll();
        }
       
    }
}
