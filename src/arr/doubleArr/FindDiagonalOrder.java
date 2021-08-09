package arr.doubleArr;

import java.util.Arrays;

public class FindDiagonalOrder {
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int rowLength = matrix.length, colLength = matrix[0].length;
        int[] res = new int[rowLength * colLength];
        int row = 0, col = 0;
        int count = rowLength + colLength - 1;
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                while (row >= 0 && col < colLength) {
                    res[index++] = matrix[row--][col++];
                }
                if (col < colLength) {
                    row++;
                } else {
                    row = row + 2;
                    col--;
                }
            } else {
                while (row < rowLength && col >= 0) {
                    res[index++] = matrix[row++][col--];
                }
                if (row < rowLength) {
                    col++;
                }else{
                    row--;
                    col = col + 2;
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        int[] res = findDiagonalOrder(arr);
        System.out.println(Arrays.toString(res));
    }
}
