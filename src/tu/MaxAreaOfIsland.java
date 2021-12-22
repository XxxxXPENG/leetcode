package tu;

public class MaxAreaOfIsland {
    private int maxArea;

    //[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
    public static void main(String[] args) {
        MaxAreaOfIsland a = new MaxAreaOfIsland();
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},//i 3 j 8
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(a.maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, 0);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, int i, int j, int area) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2;
        area++;
        maxArea = Math.max(area, maxArea);
        System.out.println("i=" + i + "，j=" + j + "，area=" + area);
        dfs(grid, i - 1, j, area);
        dfs(grid, i + 1, j, area);
        dfs(grid, i , j-1, area);
        dfs(grid, i, j + 1, area);
    }

    /*public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res = Math.max(res, dfs(grid, i, j, 0));
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j, int area) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        return dfs(grid, i - 1, j, area) + dfs(grid, i + 1, j, area) + dfs(grid, i, j - 1, area) + dfs(grid, i, j + 1, area) + 1;
    }*/
}
