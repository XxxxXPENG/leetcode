package hot100.re;

public class L79_单词搜索 {
    private int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private char[] chars;
    private char[][] board;
    private int rows;
    private int cols;
    private boolean[][] visited;
//[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
//"ABCB"
    public static void main(String[] args) {
        L79_单词搜索 a = new L79_单词搜索();
        System.out.println(a.exist(new char[][]{{'a','b','c','e'},
                {'s','f','c','s'},
                {'a','d','e','e'}},"abcd"));
    }


    public boolean exist(char[][] board, String word) {
        this.board = board;
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
        if (begin == chars.length-1) {
            return chars[begin] == board[i][j];
        }
        if (board[i][j] == chars[begin]) {
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
            visited[i][j] = false;
        }
        return false;

    }

    public boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
