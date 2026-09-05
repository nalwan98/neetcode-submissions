class Solution {
    public int leastInterval(char[] tasks, int n) {
       int[] characterCount = new int[26];
       for(char a: tasks){
            characterCount[a-'A']++;
       }
       PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
       for (int i = 0; i < 26; i++) {
            if (characterCount[i] > 0) {
                maxHeap.add(new int[]{characterCount[i], 0});
            }
        }
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
       while(maxHeap.size()>0 || q.size()>0){
        time++;
        if(maxHeap.size()>0){
            int[] curTask;
            curTask = maxHeap.poll();
            if(curTask[0]-1>0){
                curTask[0]--;
                if(curTask[0]>0){
                     curTask[1] = time+n;
                    q.add(curTask);
                }
            }
        }
        while(q.size()>0 && q.peek()[1] == time){
            maxHeap.offer(q.poll());
        }
       }
       return time;
    }
}
