package sf.str;


import java.util.HashSet;
import java.util.Set;

/**
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *  
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 */
public class Permutation {
    Set<String> set = new HashSet();

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) return new String[]{};
        boolean[] visited = new boolean[s.length()];
        process(s, "", visited);
        return set.toArray(new String[s.length()]);
    }

    public void process(String s, String letter, boolean[] visited) {
        if (s.length() == letter.length()) {
            set.add(letter);
            return ;
        }
        for (int i = 0; i < s.length(); i++) {
            if (visited[i]) continue;
            char temp = s.charAt(i);
            process(s, letter + String.valueOf(temp), visited);
            visited[i] = false;
        }
    }

}
