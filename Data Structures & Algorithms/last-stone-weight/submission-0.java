class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: stones){
            maxHeap.offer(i);
        }
        while(maxHeap.size()>=2){
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if(x==y){

            }
            else if(x<y){
                maxHeap.offer(y-x);
            }
            else{
                maxHeap.offer(x-y);
            }
        }
        if(maxHeap.size()==1){
            return maxHeap.poll();
        }
        return 0;
    }
}
