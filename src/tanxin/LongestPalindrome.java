package tanxin;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }

    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int res = 0;
        for (int v : count) {
            res += v / 2 * 2;
            if (v % 2 == 1 && res % 2 == 0) {
                res++;
            }
        }
        return res;
    }

}
