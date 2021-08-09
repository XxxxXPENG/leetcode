package arr.doubleArr;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        boolean col0_flag = false;
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0){
                col0_flag = true;
            }
            for (int j = 1; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = rowLength - 1; i >= 0; i--) {
            for (int j = colLength-1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if(col0_flag){
                matrix[i][0] = 0;
            }
        }
    }
}
