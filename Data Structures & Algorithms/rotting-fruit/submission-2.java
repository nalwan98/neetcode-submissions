class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int fruits=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j< grid[0].length; j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                    fruits++;
                }
                if(grid[i][j]==1){
                    fruits++;
                }
            }
        }
        if(q.isEmpty() && fruits!=0){
            return -1;
        }
        if(fruits==0){
            return 0;
        }
        int min=-1;
        int processedFruits=0;
        while(!q.isEmpty()){
            int size = q.size();
            min++;
            for(int i=0; i<size; i++){
                processedFruits++;
                Pair cur = q.poll();
                int x = cur.getX();
                int y = cur.getY();
                //left
                if(x>0 && grid[x-1][y]==1){
                    grid[x-1][y]=2;
                    q.add(new Pair(x-1, y));
                }
                //right
                if(x<grid.length-1 && grid[x+1][y]==1){
                    grid[x+1][y]=2;
                    q.add(new Pair(x+1, y));
                }
                //top
                if(y>0 && grid[x][y-1]==1){
                    grid[x][y-1]=2;
                    q.add(new Pair(x, y-1));
                }
                //bottom
                if(y<grid[0].length-1 && grid[x][y+1]==1){
                    grid[x][y+1]=2;
                    q.add(new Pair(x, y+1));
                }
            }
        }
        if(processedFruits<fruits){
            return -1;
        }
        return min;

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
