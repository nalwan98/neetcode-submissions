class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        //find all treasures
        for(int i=0; i<grid.length; i++){
            for(int j =0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j});
                }
            }
        }

        //BFS
        int distance = 1;
        while(q.size()>0){
            int size = q.size();
            for(int i=0; i<size;i++){
                int[] curr = q.poll();
                visited.add(curr[0]+","+curr[1]);
                if(curr[0]>0){
                    helper(grid, curr[0]-1, curr[1], visited, q, distance);
                }
                if(curr[0]<grid.length-1){
                    helper(grid, curr[0]+1, curr[1], visited, q, distance);
                }
                if(curr[1]>0){
                    helper(grid, curr[0], curr[1]-1, visited, q, distance);
                }
                if(curr[1]<grid[0].length-1){
                    helper(grid, curr[0], curr[1]+1, visited, q, distance);
                }
            }
            distance++;
        }
    }

    private void helper(int[][] grid, int r, int c, Set<String> visited, Queue<int[]> q, int distance){
        if(grid[r][c] == 2147483647 && !visited.contains(r+","+c)){
            grid[r][c] = distance;
            q.add(new int[]{r,c});
        }
    }
}
