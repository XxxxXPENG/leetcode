package dp;

public class L931_下降路径最小和 {
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        for (int row = len - 2; row >= 0; row--) {
            for (int col = 0; col < len; col++) {
                int best = matrix[row + 1][col];
                if (col + 1 < len) {
                    best = Math.min(best, matrix[row + 1][col + 1]);
                }
                if (col > 0) {
                    best = Math.min(best, matrix[row + 1][col - 1]);
                }
                matrix[row][col] += best;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int num : matrix[0]) {
            res = Math.min(res, num);
        }
        return res;
    }
}
