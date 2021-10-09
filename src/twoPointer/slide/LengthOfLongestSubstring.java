package twoPointer.slide;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abba"));
    }

    public static int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int end = 0, start = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            res = Math.max(res, end - start + 1);
            map.put(c, end + 1);
        }
        return res;
    }

        public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        int start = 0, end = 0;
        while (start < s.length() && end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                res = Math.max(res, end - start + 1);
                set.add(s.charAt(end++));
            } else {
                set.remove(s.charAt(start++));
            }
        }
        return res;

    }
}
