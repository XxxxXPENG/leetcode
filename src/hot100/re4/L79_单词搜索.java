package hot100.re4;

public class L79_单词搜索 {
    private char[][] board;
    private char[] chars;
    private boolean[][] visited;
    private int rows;
    private int cols;
    private int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        this.board = board;
        chars = word.toCharArray();
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int begin) {
        if (begin == chars.length - 1) {
            return chars[begin] == board[i][j];
        }
        visited[i][j] = true;
        if (board[i][j] == chars[begin]) {
            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];
                if (inArea(x, y) && !visited[x][y]) {
                    if (dfs(x, y, begin + 1)) {
                        return true;
                    }
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
