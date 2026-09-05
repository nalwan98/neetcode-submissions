class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Integer>> rows = new ArrayList<>();
        List<Set<Integer>> cols = new ArrayList<>();
        Map<String, Set<Integer>> squares = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                // checking rows
                if (rows.get(i).contains(num)) {
                    return false;
                }
                rows.get(i).add(num);
                // checking cols
                if (cols.get(j).contains(num)) {
                    return false;
                }
                cols.get(j).add(num);

                // checking squares
                int squarerow = i/3;
                int squarecol = j/3;
                String squareKey = Integer.toString(squarerow)+":"+Integer.toString(squarecol);
                 if (squares.containsKey(squareKey) && squares.get(squareKey).contains(num)) {
                    return false;
                }
                squares.putIfAbsent(squareKey, new HashSet<>());
                squares.get(squareKey).add(num);

            }
        }
        return true;
        
    }
}
