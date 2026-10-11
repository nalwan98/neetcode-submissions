class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                //not visited
                if(grid[i][j]==0){
                    if(visited[i][j]!=1){
                        Queue<Pair> q = new LinkedList<>();
                        q.add(new Pair(i,j));

                        while(!q.isEmpty()){
                            Pair cur = q.poll();
                            int x = cur.getX();
                            int y = cur.getY();
                            //left
                            if(x>0){
                                if(grid[x-1][y]==Integer.MAX_VALUE || (grid[x-1][y]!=-1 && grid[x-1][y]>grid[x][y]+1)){ 
                                    grid[x-1][y] = grid[x][y]+1;
                                    q.add(new Pair(x-1, y));
                                }
                                
                            }
                            //right
                            if(x<grid.length-1){
                                if(grid[x+1][y]==Integer.MAX_VALUE || (grid[x+1][y]!=-1 && grid[x+1][y]>grid[x][y]+1)){ 
                                    grid[x+1][y] = grid[x][y]+1;
                                    q.add(new Pair(x+1, y));
                                }
                            }
                            //up
                            if(y>0){
                                if(grid[x][y-1]==Integer.MAX_VALUE || (grid[x][y-1]!=-1 && grid[x][y-1] > grid[x][y]+1)){ 
                                    grid[x][y-1] = grid[x][y]+1;
                                    q.add(new Pair(x, y-1));
                                }
                            }
                            //down
                            if(y<grid[0].length-1){
                                if(grid[x][y+1]==Integer.MAX_VALUE || (grid[x][y+1]!=-1 && grid[x][y+1] > grid[x][y]+1)){ 
                                    grid[x][y+1] = grid[x][y]+1;
                                    q.add(new Pair(x, y+1));
                                }
                                
                            }
                        }
                        //set visited true
                        visited[i][j]=1;
                    }
                }
            }
        }
    }
}

class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
