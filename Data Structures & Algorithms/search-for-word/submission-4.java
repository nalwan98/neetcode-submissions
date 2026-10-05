class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (helper(board, word, i, j, visited, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean helper(char[][] board, String word,
                          int i, int j,
                          boolean[][] visited, int index) {

        // Out of bounds
        if (i < 0 || j < 0 ||
            i == board.length || j == board[0].length) {
            return false;
        }

        // Already used
        if (visited[i][j]) {
            return false;
        }

        // Character doesn't match
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        // We matched the last character
        if (index == word.length() - 1) {
            return true;
        }

        // Choose
        visited[i][j] = true;

        // Explore
        boolean found =
            helper(board, word, i, j + 1, visited, index + 1) ||
            helper(board, word, i, j - 1, visited, index + 1) ||
            helper(board, word, i + 1, j, visited, index + 1) ||
            helper(board, word, i - 1, j, visited, index + 1);

        // Undo
        visited[i][j] = false;

        return found;
    }
}