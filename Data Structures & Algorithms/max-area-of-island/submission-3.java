class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int globalMax = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j< grid[0].length; j++){
                if(grid[i][j]==1){
                    int localMax = 1;
                    grid[i][j]=2;
                    Queue<Pair> q = new LinkedList<>();
                    q.add(new Pair(i,j));
                    while(q.size()>0){
                        int size = q.size();
                        for(int k=0;k<size; k++){
                            Pair cur = q.poll();
                            if(cur.x>0 && grid[cur.x-1][cur.y]==1){
                                localMax++;
                                q.add(new Pair(cur.x-1, cur.y));
                                grid[cur.x-1][cur.y]=2;
                            }

                            //check right
                            if(cur.x<grid.length-1 && grid[cur.x+1][cur.y]==1){
                                localMax++;
                                q.add(new Pair(cur.x+1, cur.y));
                                grid[cur.x+1][cur.y]=2;
                            }

                            //check up
                            if(cur.y>0 && grid[cur.x][cur.y-1]==1){
                                localMax++;
                                q.add(new Pair(cur.x, cur.y-1));
                                grid[cur.x][cur.y-1]=2;
                            }

                            //check down
                            if(cur.y<grid[0].length-1 && grid[cur.x][cur.y+1]==1){
                                localMax++;
                                q.add(new Pair(cur.x, cur.y+1));
                                grid[cur.x][cur.y+1]=2;
                            }
                        globalMax = Math.max(globalMax, localMax);
                        }
                    }
                }
            }
        }
        return globalMax;
    }
}

class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
