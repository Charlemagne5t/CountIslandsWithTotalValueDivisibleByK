import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    res += bfs(grid, k, i, j);
                }
            }
        }

        return res;
    }

    int bfs(int[][] g, int k, int si, int sj) {
        int m = g.length;
        int n = g[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[]{si, sj});
        long sum = 0L;
        int[][] dest = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        sum += g[si][sj];
        g[si][sj] = -1;
        while (!q.isEmpty()) {
            int i = q.peekFirst()[0];
            int j = q.removeFirst()[1];
            for (int[] d : dest) {
                int ni = i + d[0];
                int nj = j + d[1];
                if (ni < 0 || ni == m || nj < 0 || nj == n || g[ni][nj] <= 0) {
                    continue;
                }
                q.offer(new int[]{ni, nj});
                sum += g[ni][nj];
                g[ni][nj] = -1;


            }
        }

        return sum % k == 0 ? 1 : 0;

    }
}