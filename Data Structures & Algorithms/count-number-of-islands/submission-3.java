
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                // FIX: Removed unnecessary if(grid[i][j] == 2)

                // FIX: Use character '1', not integer 1
                if (grid[i][j] == '1') {
                    count++;

                    Queue<Pair<Integer, Integer>> q = new LinkedList<>();
                    q.add(new Pair<>(i, j)); // FIX: Added <>

                    grid[i][j] = '2'; // FIX: Character '2'

                    while (q.size() != 0) {
                        int size = q.size();

                        for (int y = 0; y < size; y++) {
                            Pair<Integer, Integer> cur = q.poll();

                            // FIX: Use getters instead of private fields
                            if (cur.getk() > 0 &&
                                grid[cur.getk()-1][cur.getv()] == '1') {

                                q.add(new Pair<>(cur.getk()-1, cur.getv()));
                                grid[cur.getk()-1][cur.getv()] = '2';
                            }

                            if (cur.getk() < grid.length-1 &&
                                grid[cur.getk()+1][cur.getv()] == '1') {

                                q.add(new Pair<>(cur.getk()+1, cur.getv()));
                                grid[cur.getk()+1][cur.getv()] = '2';
                            }

                            if (cur.getv() > 0 &&
                                grid[cur.getk()][cur.getv()-1] == '1') {

                                q.add(new Pair<>(cur.getk(), cur.getv()-1));
                                grid[cur.getk()][cur.getv()-1] = '2';
                            }

                            if (cur.getv() < grid[0].length-1 &&
                                grid[cur.getk()][cur.getv()+1] == '1') {

                                q.add(new Pair<>(cur.getk(), cur.getv()+1));
                                grid[cur.getk()][cur.getv()+1] = '2';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}

// FIX: Pair fields accessed using getters
class Pair<K, V> {
    private final K k;
    private final V v;

    public Pair(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public K getk() { return k; }
    public V getv() { return v; }
}
