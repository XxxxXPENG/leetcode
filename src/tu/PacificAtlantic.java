package tu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic {
    public static void main(String[] args) {
        PacificAtlantic p = new PacificAtlantic();
        int[][] c = {
                {10, 10, 10},
                {10, 1, 10},
                {10, 10, 10}
        };
        System.out.println(p.pacificAtlantic(c));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int rows = heights.length, cols = heights[0].length;
        boolean[][] canReachP = new boolean[rows][cols], canReachX = new boolean[rows][cols];
        //从边界出发，遍历可达陆地
        for (int i = 0; i < rows; i++) {
            dfs(heights,canReachP, i, 0);
            dfs(heights,canReachX, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            dfs(heights,canReachP, 0, j);
            dfs(heights,canReachX, rows - 1, j);
        }
        //将同时可达的陆地返回
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canReachP[i][j] && canReachX[i][j]) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }


    private void dfs(int[][] heights,boolean[][] canReach, int i, int j) {
        if (canReach[i][j]) {
            return;
        }
        canReach[i][j] =true;
        if(i-1 >=0 && heights[i-1][j] >= heights[i][j]){
            dfs(heights, canReach, i-1, j);
        }
        if (j - 1 >= 0 && heights[i][j - 1] >= heights[i][j]) {
            dfs(heights, canReach, i, j-1);
        }
        if (i + 1 < heights.length && heights[i + 1][j] >= heights[i][j]) {
            dfs(heights, canReach, i+1, j);
        }
        if (j + 1 < heights[0].length && heights[i][j + 1] >= heights[i][j]) {
            dfs(heights, canReach, i, j+1);
        }
    }
}
