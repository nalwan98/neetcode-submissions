class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                
                //Row checking
                if(board[i][j]!='.'){
                    rows.put(i, rows.getOrDefault(i, new HashSet<>()));
                    if(rows.get(i).contains(board[i][j])){
                        return false;
                    }
                    else{
                        rows.get(i).add(board[i][j]);
                    }
                    //Columns checking
                    cols.put(j, cols.getOrDefault(j, new HashSet<>()));
                    if(cols.get(j).contains(board[i][j])){
                        return false;
                    }
                    else{
                        cols.get(j).add(board[i][j]);
                    }

                    //Square checking
                    //we will do this by knowing that every three rows when divided to 3 will give the same integer
                    //same for columns. ex: 0/3, 1/3, 2/3 =0 3/3, 4/3, 5/3=1 ...

                    int squareRow = i/3;
                    int squareCol = j/3;
                    String squareKey = Integer.toString(squareRow)+":"+Integer.toString(squareCol);
                    squares.put(squareKey, squares.getOrDefault(squareKey, new HashSet<>()));
                    if(squares.get(squareKey).contains(board[i][j])){
                        return false;
                    }
                    else{
                        squares.get(squareKey).add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}
