package dp;

public class L392_判断子序列 {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0) return true;
        char[] sArr = s.toCharArray();
        int index = 0;
        for (char c : t.toCharArray()) {
            if (sArr[index] == c) {
                index++;
            }
            if (index == s.length()) {
                return true;
            }
        }
        return false;

    }
}
