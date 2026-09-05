class Solution {
    public void solve(char[][] board) {
      Queue<int[]> q = new LinkedList<>();
      int rows= board.length;
      int cols = board[0].length;
      //add O in top and bottom rows;
      for(int i=0; i<cols; i++){
        if(board[0][i]=='O'){
            q.add(new int[]{0, i});
        }
        if(board[rows-1][i]=='O'){
            q.add(new int[]{rows-1,i});
        }
      }

      //add O from first and last col without repeting those added from rows;
      for(int i=1; i<rows-1; i++){
        if(board[i][0]=='O'){
            q.add(new int[]{i, 0});
        }
        if(board[i][cols-1]=='O'){
            q.add(new int[]{i,cols-1});
        }
      } 
    
      //run traversal on 'O' and set them to 'V'
      while(q.size()>0){
        int[] curr = q.poll();
        int row = curr[0];
        int col = curr[1];
        board[row][col]= 'V';
         int[] directions = {-1, 0, 1, 0, -1, 0};
            for (int d = 0; d < directions.length - 1; d++) {
                int r = row + directions[d];
                int c = col + directions[d + 1];
                if (r >= 0 && r < rows && c >= 0 && c < cols && board[r][c]== 'O') {
                    q.add(new int[]{r, c});
                }
            }
      }

      for(int i=0; i<rows; i++){
        for(int j=0; j<cols; j++){
            if(board[i][j]!='V'){
                board[i][j] = 'X';
            }
            else{
                board[i][j] = 'O';
            }
        }
      }

    }
}
