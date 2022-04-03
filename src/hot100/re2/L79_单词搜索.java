package hot100.re2;

public class L79_单词搜索 {
    private int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private boolean[][] visited;
    private char[][] board;
    private char[] chars;
    private int rows;
    private int cols;


    public boolean exist(char[][] board, String word) {
        this.board=board;
        chars = word.toCharArray();
        rows = board.length;
        cols = board[0].length;
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
            return board[i][j] == chars[begin];
        }
        visited[i][j] = true;
        for (int[] direction : directions) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (inArea(newX, newY) && !visited[newX][newY]) {
                if (dfs(newX, newY, begin + 1)) {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
