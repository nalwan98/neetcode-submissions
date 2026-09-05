
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];
        Queue<int[]> qp = new LinkedList<>();
        Queue<int[]> qa = new LinkedList<>();

        // Initialize Pacific Ocean
        for (int i = 0; i < rows; i++) {
            qp.add(new int[]{i, 0});
            pacificReachable[i][0] = true; // Marking cells reachable by Pacific
        }
        for (int i = 0; i < cols; i++) {
            qp.add(new int[]{0, i});
            pacificReachable[0][i] = true; // Marking cells reachable by Pacific
        }

        // Initialize Atlantic Ocean
        for (int i = 0; i < rows; i++) {
            qa.add(new int[]{i, cols - 1});
            atlanticReachable[i][cols - 1] = true; // Marking cells reachable by Atlantic
        }
        for (int i = 0; i < cols; i++) {
            qa.add(new int[]{rows - 1, i});
            atlanticReachable[rows - 1][i] = true; // Marking cells reachable by Atlantic
        }

        // BFS for Pacific
        bfs(heights, qp, pacificReachable);

        // BFS for Atlantic
        bfs(heights, qa, atlanticReachable);

        // Collect results
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void bfs(int[][] heights, Queue<int[]> q, boolean[][] reachable) {
        int rows = heights.length;
        int cols = heights[0].length;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            // Check all 4 directions
            int[] directions = {-1, 0, 1, 0, -1, 0};
            for (int d = 0; d < directions.length - 1; d++) {
                int r = row + directions[d];
                int c = col + directions[d + 1];
                if (r >= 0 && r < rows && c >= 0 && c < cols && heights[r][c] >= heights[row][col] && !reachable[r][c]) {
                    reachable[r][c] = true; // Mark as reachable
                    q.add(new int[]{r, c});
                }
            }
        }
    }
}
