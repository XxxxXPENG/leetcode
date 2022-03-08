package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17_电话号码的字母组合 {

    public static void main(String[] args) {
        L17_电话号码的字母组合 a = new L17_电话号码的字母组合();
        System.out.println(a.letterCombinations("23"));
    }


    public static Map<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        dfs(res, 0, digits, new StringBuilder());
        return res;
    }

    private void dfs(List<String> res, int index, String digits, StringBuilder stringBuilder) {
        if (index == digits.length()) {
            res.add(stringBuilder.toString());
        } else {
            //获取数字
            String letters = map.get(digits.charAt(index));
            for (int i = 0; i < letters.length(); i++) {
                //获取第i个位置组合
                stringBuilder.append(letters.charAt(i));
                //递归遍历i+1个位置组合
                dfs(res, index + 1, digits, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }
}
