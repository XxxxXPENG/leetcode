package backTrack.re;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        solve(chess, res, 0);
        return res;
    }

    private void solve(char[][] chess, List<List<String>> res, int row) {
        if (row == chess.length) {
            res.add(construct(chess));
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if (valid(chess, row, col)) {
                chess[row][col] = 'Q';
                solve(chess, res, row+1);
                chess[row][col] = '.';
            }
        }
    }

    public boolean valid(char[][] chess,int row,int col) {
        //列
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        //右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--,j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        //左上
        for (int i = row-1,j = col-1; i >=0 && j >=0 ; i--,j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> construct(char[][] chess) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            res.add(new String(chess[i]));
        }
        return res;
    }
}
