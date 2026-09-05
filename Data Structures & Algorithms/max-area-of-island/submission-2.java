class Solution {
    
    boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        
        int rows = grid.length;
        int columns = grid[0].length;
        visited = new boolean[rows][columns];
        int res=0;

        for(int i=0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                int c = grid[i][j];
                if(c==1 && !visited[i][j]){
                    res= Math.max(res,bfs(i,j,grid));
                }
            }
        }
        return res;
    }

    private int bfs(int i, int j, int[][] grid){
        int curArea = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true; // Mark the starting cell as visited

        // Directions: up, down, left, right
        int[][] directions = {
            {-1, 0}, // Up
            {1, 0},  // Down
            {0, -1}, // Left
            {0, 1}   // Right
        };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            curArea++; // Count the area

            // Explore all four directions
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check if the new position is within bounds and is land
                if (newRow >= 0 && newRow < grid.length &&
                    newCol >= 0 && newCol < grid[0].length &&
                    grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    q.add(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true; // Mark as visited
                }
            }
        }
        return curArea; // Return the area of the island found
    }
}
