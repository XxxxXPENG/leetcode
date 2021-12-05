package tu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();
        Map<Integer, Set<Integer>> areaMap = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            rowMap.put(i, new HashSet<>());
            colMap.put(i, new HashSet<>());
            areaMap.put(i, new HashSet<>());
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                int num = board[row][col] - '0';
                int idx = (row / 3) * 3 + col / 3;
                if (rowMap.get(row).contains(num) || colMap.get(col).contains(num) || areaMap.get(idx).contains(num)) {
                    return false;
                }
                rowMap.get(row).add(num);
                colMap.get(col).add(num);
                areaMap.get(idx).add(num);
            }
        }
        return true;
    }
}
