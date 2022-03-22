package hot100.rre;

public class L48_旋转图像 {
    public static void main(String[] args) {
        L48_旋转图像 a = new L48_旋转图像();
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        a.rotate(arr);
        for (int[] nums : arr) {
            for (int num : nums) {
                System.out.printf(num +",");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
