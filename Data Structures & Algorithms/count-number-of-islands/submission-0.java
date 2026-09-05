class Solution {
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int columns = grid[0].length;
        visited = new boolean[rows][columns];
        int res=0;

        for(int i=0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                char c = grid[i][j];
                if(c=='1' && !visited[i][j]){
                    bfs(i,j,grid);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(int i, int j, char[][] grid){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        while(q.size()>0){
            int size = q.size();
            for(int k =0; k<size; k++){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                visited[row][col]=true;
                if(row!=0){
                    if(grid[row-1][col] == '1' && !visited[row-1][col]){
                        q.add(new int[]{row-1,col});
                    }
                }
                if(row!=grid.length-1){
                    if(grid[row+1][col] == '1' && !visited[row+1][col]){
                        q.add(new int[]{row+1,col});
                    }
                }
                if(col!=0){
                    if(grid[row][col-1] == '1' && !visited[row][col-1]){
                        q.add(new int[]{row,col-1});
                    }
                }
                if(col!=grid[0].length-1){
                    if(grid[row][col+1] == '1' && !visited[row][col+1]){
                        q.add(new int[]{row,col+1});
                    }
                }
            }
        }
    }
}
