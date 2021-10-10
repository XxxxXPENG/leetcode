package twoPointer.slide;

import java.util.Arrays;

public class CheckInclusion {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidboaoo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) {
            return false;
        }
        int[] s1Cnt = new int[26];
        int[] s2Cnt = new int[26];
        for (int i = 0; i < m; i++) {
            s1Cnt[s1.charAt(i) - 'a']++;
            s2Cnt[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(s1Cnt, s2Cnt)) {
            return true;
        }
        for (int i = m; i < n; i++) {
            s2Cnt[s2.charAt(i - m) - 'a']--;
            s2Cnt[s2.charAt(i) - 'a']++;
            if (Arrays.equals(s1Cnt, s2Cnt)) {
                return true;
            }
        }
        return false;
    }
}
