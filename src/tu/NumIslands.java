package tu;

public class NumIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        NumIslands numIslands = new NumIslands();
        System.out.println(numIslands.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    infect(grid,i,j,row,col);
                    res++;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(grid[i][j]+",");
            }
            System.out.println();
        }
        return res;
    }

    /**
     * 将所有棋盘内1的值换为2
     */
    public void infect(char[][] grid, int i, int j, int row, int col) {
        if(i >= row || i < 0 || j>=col || j < 0 || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        infect(grid, i + 1, j, row, col);
        infect(grid, i - 1, j, row, col);
        infect(grid, i, j + 1, row, col);
        infect(grid, i, j - 1, row, col);
    }
}
