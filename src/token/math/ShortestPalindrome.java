package token.math;

import java.util.Objects;

public class ShortestPalindrome {

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa"));

        System.out.println(shortestPalindrome("abbacd"));  //"dcabbacd"


        System.out.println(longestPalindrome("abbacd"));
    }


    public static String shortestPalindrome2(String s) {
        int len = s.length();
        String reverseStr = new StringBuilder(s).reverse().toString();
        for (int i = len; i >= 0; i--) {
            if (s.substring(0, i).equals(reverseStr.substring(len - i))) {
                return reverseStr.substring(0,len - i) + s;
            }
        }
        return "";
    }


    public static String shortestPalindrome(String s) {
        String longStr = longestPalindrome(s);
        int index = Objects.equals(longStr, "" )? 1 : longStr.length();
        String temp = s;
        while (!isPalindrome(s)) {
            char c = temp.charAt(index++);
            s = c + s;
        }
        return s;
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    /**
     * 返回头部最长回文子串
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int index = s.length() - 1;
        while (index > 1) {
            String temp = s.substring(0, index--);
            if (isPalindrome(temp)) {
                return temp;
            }
        }
        return "";
    }
}
