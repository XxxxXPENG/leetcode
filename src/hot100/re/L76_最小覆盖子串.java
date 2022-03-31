package hot100.re;

import java.util.HashMap;
import java.util.Map;

public class L76_最小覆盖子串 {
    public static void main(String[] args) {
        L76_最小覆盖子串 a = new L76_最小覆盖子串();
        System.out.println(a.minWindow("cabwefgewcwaefgcf","cae"));
    }

    Map<Character, Integer> sMap = new HashMap<>();
    Map<Character, Integer> tMap = new HashMap<>();

    public String minWindow(String s, String t) {
        char[] tChars = t.toCharArray();
        for (int i = 0; i < tChars.length; i++) {
            tMap.put(tChars[i], tMap.getOrDefault(tChars[i], 0) + 1);
        }

        int l = 0, r = -1, len = Integer.MAX_VALUE;
        int ansL = -1, ansR=-1;
        char[] sChars = s.toCharArray();
        while (r < s.length()) {
            //右指针移动
            r++;
            if (r < s.length() && tMap.containsKey(sChars[r])) {
                sMap.put(sChars[r], sMap.getOrDefault(sChars[r], 0) + 1);
            }
            //左指针移动
            while (check() && l <= r) {
                if (len > r - l + 1) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (tMap.containsKey(sChars[l])) {
                    sMap.put(sChars[l], sMap.getOrDefault(sChars[l], 0) - 1);
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
            if (sMap.getOrDefault(k,0) < v) {
                return false;
            }
        }
        return true;
    }
}
