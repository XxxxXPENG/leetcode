package arr.doubleArr;

import java.util.Arrays;

public class MatrixReshape {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (r * c != m * n) {
            return nums;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            res[i / c][i % c] = nums[i / n][i % n];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2},
                {3, 4}};
        for (int[] ints : matrixReshape(nums, 1, 4)) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
