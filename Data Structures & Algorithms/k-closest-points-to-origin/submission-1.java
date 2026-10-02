class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1])));

        for(int i=0; i<points.length; i++){
            int[] cur = points[i];
            maxHeap.add(cur);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        for(int i=0; i<k; i++){
            res[i] = maxHeap.poll();
        }
    return res;
    }
}
