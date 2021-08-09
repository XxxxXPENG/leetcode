package token.changeStr;

import java.util.ArrayList;
import java.util.List;

public class Convert {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            list.add(new StringBuilder());
        }
        int index = 0;
        boolean flag = false;
        for (char c : s.toCharArray()) {
            list.get(index).append(c);
            if (index == numRows - 1 || index == 0) {
                flag = !flag;
            }
            index += flag ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        list.forEach(sb -> res.append(sb.toString()));
        return res.toString();

    }
}
