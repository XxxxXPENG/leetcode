package str.re;


public class LongestPalindrome2 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLen = expand(s, i, i);
            int evenLen = expand(s, i, i + 1);
            int maxLen = Math.max(oddLen, evenLen);
            if (maxLen > end - start + 1) {
                //偶数情况需要-1
                start = i - (maxLen-1) / 2;
                end = i + maxLen/2;
            }

        }
        return s.substring(start, end + 1);

    }


    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right-left-1;
    }
}