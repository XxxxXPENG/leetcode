package week.wk6;

import java.util.ArrayList;
import java.util.List;

public class L6016_Excel表中某个范围内的单元格 {

    public static void main(String[] args) {
        L6016_Excel表中某个范围内的单元格 a = new L6016_Excel表中某个范围内的单元格();
        System.out.println(a.cellsInRange("K1:L2"));
    }

    public List<String> cellsInRange(String s) {
        String[] arr = s.split(":");
        char colStart = arr[0].charAt(0);
        char rowStart = arr[0].charAt(1);
        char colEnd = arr[1].charAt(0);
        char rowEnd = arr[1].charAt(1);
        List<String> res = new ArrayList<>();
        for (char j = colStart; j <= colEnd; j++) {
            for (char i = rowStart; i <= rowEnd; i++) {
                String str = j + "" + i;
                res.add(str);
            }
        }
        return res;
    }
}
