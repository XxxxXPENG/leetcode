package hot100;

import java.util.HashMap;
import java.util.Map;

public class L76_最小覆盖子串 {
    Map<Character, Integer> tMap = new HashMap<>();
    Map<Character, Integer> sMap = new HashMap<>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1, sLen = s.length();
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        while (r < sLen) {
            r++;
            if (r < sLen && tMap.containsKey(s.charAt(r))) {
                sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (len > l - r + 1) {
                    len = r - l + 1;
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
            Character c = entry.getKey();
            Integer i = entry.getValue();
            if (sMap.getOrDefault(c, 0) < i) {
                return false;
            }
        }
        return true;
    }
}
