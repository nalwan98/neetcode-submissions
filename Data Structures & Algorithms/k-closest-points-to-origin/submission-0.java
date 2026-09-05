class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for(int[] i: points){
            int[] curArray = new int[3];
            curArray[0] = (int)(Math.pow((i[0]-0),2) + Math.pow((i[1]-0),2));
            curArray[1]=i[0];
            curArray[2]=i[1];
            minHeap.offer(curArray);
        }
        int[][] res = new int[k][2];
        for(int i=0; i<k; i++){
            int[] curr = new int[2];
            int[] closest = minHeap.poll();
            curr[0]=closest[1];
            curr[1] = closest[2];
            res[i]=curr;
         }

         return res;

    }
}
