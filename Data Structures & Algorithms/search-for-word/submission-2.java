class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length()==0){
            return true;
        }
        boolean res = false;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==word.charAt(0)){
                    res = res|| dfs(i,j,board,word,0);
                }
                if(res==true){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, char[][]board, String word,int index){
        if(index == word.length()){
            return true;
        }
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        
        int[] directions = {-1,0,1,0,-1};
        boolean res = false;
        char temp = board[row][col];
        board[row][col] = '#';
        for(int i=0; i<directions.length-1; i++){
            int r = row + directions[i];
            int c = col + directions[i+1];
                res = res || dfs(r,c,board, word, index+1);
        }
        board[row][col] = temp; // Restore the character
        return res;
    }

}
