
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        Queue<Pair> q = new LinkedList<>();

        // Upper and bottom
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = 'V'; // FIX: Mark visited immediately
                q.add(new Pair(0, i));
            }

            if (board[board.length-1][i] == 'O') {
                board[board.length-1][i] = 'V';
                // FIX: Use board.length for row index
                q.add(new Pair(board.length-1, i));
            }
        }

        // Left and right
        for (int i = 1; i < board.length-1; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'V';
                q.add(new Pair(i, 0));
            }

            // FIX: Rightmost column is length-1
            if (board[i][board[0].length-1] == 'O') {
                board[i][board[0].length-1] = 'V';
                q.add(new Pair(i, board[0].length-1));
            }
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int x = cur.getX();
            int y = cur.getY();

            // Up
            if (x > 0 && board[x-1][y] == 'O') {
                board[x-1][y] = 'V'; // FIX: Mark visited
                q.add(new Pair(x-1, y));
            }

            // Down
            if (x < board.length-1 && board[x+1][y] == 'O') {
                board[x+1][y] = 'V';
                q.add(new Pair(x+1, y));
            }

            // Left
            if (y > 0 && board[x][y-1] == 'O') {
                board[x][y-1] = 'V';
                q.add(new Pair(x, y-1));
            }

            // Right
            if (y < board[0].length-1 && board[x][y+1] == 'O') {
                board[x][y+1] = 'V';
                q.add(new Pair(x, y+1));
            }
        }

        // Convert surrounded O to X, and V back to O
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 'V') {
                    board[i][j] = 'X';
                } else {
                    board[i][j] = 'O';
                }
            }
        }
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
