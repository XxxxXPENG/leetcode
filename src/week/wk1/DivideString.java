package week.wk1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideString {
    public static void main(String[] args) {
        DivideString s = new DivideString();
        System.out.println(Arrays.toString(s.divideString("abcdefghij", 3, 'x')));
    }

    public String[] divideString(String s, int k, char fill) {
        if (s == null || s.length() == 0) {
            return new String[]{};
        }
        List<String> res = new ArrayList<>();
        int start = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (i % k == 0) {
                String str = s.substring(start, i);
                start = i;
                res.add(str);
            }
        }
        boolean needFilled = s.length() % k != 0;
        if (needFilled) {
            int end = s.length() % k;
            int tail = k - end;
            String endStr = s.substring(start);
            StringBuilder sb = new StringBuilder(endStr);
            while (tail > 0) {
                sb.append(fill);
                tail--;
            }
            res.add(sb.toString());
        }
        return res.toArray(new String[0]);
    }
}
