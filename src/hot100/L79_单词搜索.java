package hot100;

public class L79_单词搜索 {
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private char[][] board;
    private char[] charArr;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        charArr = word.toCharArray();
        int rows = board.length;
        int cols = board[0].length;
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
        if (begin == charArr.length-1) {
            return board[i][j] == charArr[begin];
        }
        if (board[i][j] == charArr[begin]) {
            visited[i][j] = true;
            for (int[] direction : DIRECTIONS) {
                int newX = i + direction[0];
                int newY = j + direction[1];
                if (isArea(newX, newY) && !visited[newX][newY]) {
                    if (dfs(newX, newY, begin + 1)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;

    }

    private boolean isArea(int x, int y) {
        int rows = board.length;
        int cols = board[0].length;
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
