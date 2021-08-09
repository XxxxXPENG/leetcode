package arr.doubleArr;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int count = (Math.min(n, m) + 1)/2;


        while (i < count){
            for (int j = i; j < n - i; j++) {
                res.add(matrix[i][j]);
            }
            for (int j = i+1; j < m -i; j++) {
                res.add(matrix[j][n-1-i]);
            }
            for (int j = (n-1)-(i+1); j >= i && (m-1-i != i); j--) {
                res.add(matrix[(m-1)-i][j]);
            }
            for (int j = (m-1)-(i+1); j >= i+1 && (n-1-i) != i; j--) {
                res.add(matrix[j][i]);
            }


            i++;
        }

        return res;
    }


    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix[0].length == 0) {
            return res;
        }
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int col = right - 1; col > left; col--) {
                    res.add(matrix[bottom][col]);
                }
                for (int row = bottom; row > top; row--) {
                    res.add(matrix[row][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
