package hot100.re7;

import java.util.HashMap;
import java.util.Map;

public class L76_最小覆盖子串 {

    public static void main(String[] args) {
        L76_最小覆盖子串 a = new L76_最小覆盖子串();
        System.out.println(a.minWindow("cabwefgewcwaefgcf","cae"));
    }

    private Map<Character, Integer> sMap = new HashMap<>();
    private Map<Character, Integer> tMap = new HashMap<>();

    public String minWindow(String s, String t) {
        char[] tChars = t.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            char c = tChars[i];
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        while (r < s.length()) {
            r++;
            if (r < s.length() && tMap.containsKey(s.charAt(r))) {
                sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (len > r - l + 1) {
                    len = r-l+1;
                    ansL = l;
                    ansR = l + len;
                }
                if (tMap.containsKey(s.charAt(l))) {
                    sMap.put(s.charAt(l), sMap.getOrDefault(s.charAt(l), 0) - 1);
                }
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);

    }

    private boolean check() {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            Character k = entry.getKey();
            Integer v = entry.getValue();
            if (sMap.getOrDefault(k, 0) < v) {
                return false;
            }
        }
        return true;
    }
}
