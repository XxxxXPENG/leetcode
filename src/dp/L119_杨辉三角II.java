package dp;

import java.util.ArrayList;
import java.util.List;

public class L119_杨辉三角II {

    public static void main(String[] args) {
        L119_杨辉三角II a = new L119_杨辉三角II();
        System.out.println(a.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(res.get(j-1)+res.get(j));
                }
            }
            res = list;
        }
        return res;
    }
}
