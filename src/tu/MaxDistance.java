package tu;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxDistance {
    public int maxDistance(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = -1;
                } else {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int maxLen = 0, len = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == -1) {
                    grid[newX][newY] = grid[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                    len = grid[newX][newY];
                    maxLen = Math.max(len, maxLen);
                }
            }
        }
        return maxLen-1;
    }
}
