package hot100;

import java.util.HashMap;
import java.util.Map;

public class L3_无重复字符的最长子串 {

    public static void main(String[] args) {
        L3_无重复字符的最长子串 a = new L3_无重复字符的最长子串();
        System.out.println(a.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s){
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            res = Math.max(res, end - start + 1);
            map.put(c, end + 1);
        }
        return res;
    }
}
