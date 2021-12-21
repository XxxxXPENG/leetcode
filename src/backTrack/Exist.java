package backTrack;

public class Exist {
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int rows;
    private int cols;
    private int len;
    private boolean[][] visited;
    private char[] charArray;
    private char[][] board;


    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        charArray = word.toCharArray();
        len = word.length();
        this.board = board;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int begin) {
        if (begin == len - 1) {
            return board[i][j] == charArray[begin];
        }
        if (board[i][j] == charArray[begin]) {
            visited[i][j] = true;
            for (int[] direction : DIRECTIONS) {
                int newX = i + direction[0];
                int newY = j + direction[1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (dfs(newX, newY, begin + 1)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;
    }


    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

}
