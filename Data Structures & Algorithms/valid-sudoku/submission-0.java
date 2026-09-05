class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int hash(){
        int prime = 31; // A small prime number
        int result = this.x;
        result = prime * result + this.y; // Incorporating y to ensure order matters
        return result;
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<board.length; i++){
            Set<Character> set = new HashSet<>();
            for(int j=0; j<board[i].length; j++){
                if(set.contains(board[i][j])){
                    return false;
                }
                if(board[i][j]!= '.'){
                    set.add(board[i][j]);
                }
            }
            
        }

        for(int i=0; i<board.length; i++){
            Set<Character> set = new HashSet<>();
            for(int j=0; j<board[i].length; j++){
                if(set.contains(board[j][i])){
                    return false;
                }
                if(board[j][i]!= '.'){
                    set.add(board[j][i]);
                }
            }
            
        }
        Map<Integer, Set<Character>> map = new HashMap<>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                Pair p = new Pair(i/3, j/3);
                int phash = p.hash();
                if(map.containsKey(phash)){
                    Set<Character> set = map.get(phash);
                    if(set.contains(board[i][j])){
                    return false;
                    }
                    if(board[i][j]!= '.'){
                    set.add(board[i][j]);
                    }
                }
                else{
                    Set<Character> set = new HashSet<>();
                    if(board[i][j]!= '.'){
                    set.add(board[i][j]);
                    }
                    map.put(phash, set);
                }
            }
            
        }
        return true;
    }
}
