package week.wk5;

public class L6009_使两字符串互为字母异位词的最少步骤数 {
    public int minSteps(String s, String t) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            chars[c-'a']--;
        }
        int res = 0;
        for (int a : chars) {
            res += Math.abs(a);
        }
        return res;


    }
}
