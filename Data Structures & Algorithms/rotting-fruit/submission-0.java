class Solution {
    public int orangesRotting(int[][] grid) {
        Set<String>  visited= new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        int fresh=0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int min=0;
        while(q.size()>0 && fresh>0){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                visited.add(curr[0]+","+curr[1]);
                if(curr[0]>0){
                    fresh = fresh - helper(grid, curr[0]-1, curr[1], visited, q);
                    
                }
                if(curr[0]<grid.length-1){
                    fresh = fresh - helper(grid, curr[0]+1, curr[1], visited, q);
                }
                if(curr[1]>0){
                    fresh = fresh - helper(grid, curr[0], curr[1]-1, visited, q);
                }
                if(curr[1]<grid[0].length-1){
                    fresh = fresh - helper(grid, curr[0], curr[1]+1, visited, q);
                }
            }
            min++;
        }
        if(fresh>0){
            return -1;
        }
        return min;
    }

    private int helper(int[][] grid, int r, int c, Set<String> visited, Queue<int[]> q){
        if(grid[r][c] == 1 && !visited.contains(r+","+c)){
            grid[r][c] = 2;
            q.add(new int[]{r,c});
            return 1;
        }
        return 0;
    }
}
