package hot100.re4;

public class L48_旋转图像 {
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m/2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
