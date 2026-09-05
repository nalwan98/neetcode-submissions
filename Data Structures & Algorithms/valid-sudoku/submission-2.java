class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int hash() {
        int prime = 31; // A small prime number
        int result = this.x;
        result = prime * result + this.y; // Incorporating y to ensure order matters
        return result;
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> map = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char current = board[i][j];

                if (current == '.') continue; // Skip empty cells

                // 1. Validate row
                if (!rows.containsKey(i)) {
                    rows.put(i, new HashSet<>());
                }
                if (rows.get(i).contains(current)) {
                    return false; // Duplicate in row
                } else {
                    rows.get(i).add(current);
                }

                // 2. Validate column
                if (!cols.containsKey(j)) {
                    cols.put(j, new HashSet<>());
                }
                if (cols.get(j).contains(current)) {
                    return false; // Duplicate in column
                } else {
                    cols.get(j).add(current);
                }

                // 3. Validate 3x3 sub-box
                Pair p = new Pair(i / 3, j / 3);
                int phash = p.hash();
                if (!map.containsKey(phash)) {
                    map.put(phash, new HashSet<>());
                }
                if (map.get(phash).contains(current)) {
                    return false; // Duplicate in sub-box
                } else {
                    map.get(phash).add(current);
                }
            }
        }
        return true; // All validations passed
    }
}
