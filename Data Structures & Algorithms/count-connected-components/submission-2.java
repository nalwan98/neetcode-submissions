class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited= new boolean[n];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(i, new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        int count=0;
        for(int i=0; i<n; i++){
            if(visited[i]){
                continue;
            }
            count++;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i] = true; // FIX: Mark when adding to queue
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int j: map.get(cur)){
                    if(!visited[j]){
                        q.add(j);
                        visited[j] = true; // FIX: Mark before enqueue
                    }
                }
            }
        }
        return count;
    }
}
