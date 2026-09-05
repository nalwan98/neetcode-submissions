class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjlist.add(new ArrayList<>());
        }
        for(int[] i: edges){
            adjlist.get(i[0]).add(i[1]);
            adjlist.get(i[1]).add(i[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i=0; i<n; i++){
            if(!visited.contains(i)){
                count++;
                dfs(adjlist, i, visited);
            }
        }
        return count;
    }
    private void dfs(List<List<Integer>> adjlist, int node, Set<Integer> visited){
        if(visited.contains(node)){
            return;
        }
        visited.add(node);
        for(int i: adjlist.get(node)){
            dfs(adjlist, i, visited);
        }
    }
}
