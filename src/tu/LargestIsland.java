package tu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int largestIsland(int[][] grid) {
        int res = 0;
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        int index = 2;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int area = getArea(grid, i, j, index);
                    maxArea = Math.max(area, maxArea);
                    map.put(index++, area);
                }
            }
        }
        //遍历海洋周围的陆地
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    int size = plusArea(grid, i, j, map);
                    res = Math.max(res, size);
                }
            }
        }
        return Math.max(res,maxArea);
    }


    private static int getArea(int[][] grid, int i, int j, int index) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = index;
            return 1
                    + getArea(grid, i - 1, j, index)
                    + getArea(grid, i + 1, j, index)
                    + getArea(grid, i, j - 1, index)
                    + getArea(grid, i, j + 1, index);
        }
        return 0;
    }
    private static int plusArea(int[][] grid, int x, int y, Map<Integer, Integer> map) {
        if (!isArea(grid, x, y)) {
            return 0;
        }
        if (grid[x][y] != 0) {
            return 0;
        }
        Integer size = 0;
        //叠加面积很关键的一步，记得去重，因为海洋四周接壤的土地有可能是同一块陆地
        Set<Integer> set = new HashSet<Integer>();
        if (isArea(grid, x - 1, y) && grid[x - 1][y] >= 2) {
            set.add(grid[x - 1][y]);
        }
        if (isArea(grid, x + 1, y) && grid[x + 1][y] >= 2) {
            set.add(grid[x + 1][y]);
        }
        if (isArea(grid, x, y - 1) && grid[x][y - 1] >= 2) {
            set.add(grid[x][y - 1]);
        }
        if (isArea(grid, x, y + 1) && grid[x][y + 1] >= 2) {
            set.add(grid[x][y + 1]);
        }
        for (Integer num : set) {
            size += map.get(num);
        }
        //海洋变土地，+1
        ++size;
        return size;
    }

    private static int area(int[][] grid, int x, int y, int index) {
        if (!isArea(grid, x, y)) {
            return 0;
        }
        if (grid[x][y] != 1) {
            return 0;
        }
        //用index来代表同一块陆地存放面积的索引值
        grid[x][y] = index;
        return 1
                + area(grid, x + 1, y, index)
                + area(grid, x - 1, y, index)
                + area(grid, x, y + 1, index)
                + area(grid, x, y - 1, index);
    }

    private static boolean isArea(int[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
}