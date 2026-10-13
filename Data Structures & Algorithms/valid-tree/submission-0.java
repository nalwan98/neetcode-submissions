class Solution {
    public boolean validTree(int n, int[][] edges) {
         Map<Integer, Set<Integer>> map = new HashMap<>();
         boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            map.put(i, new HashSet<>());
        }

        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        while(!q.isEmpty()){
            int cur = q.poll();
            if(visited[cur]){
                return false;
            }
            visited[cur]=true;

            for(int i: map.get(cur)){
                map.get(i).remove(cur);
                q.add(i);
            }
        }
        for(int i=0; i<n;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
}
