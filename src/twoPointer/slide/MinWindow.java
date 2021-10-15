package twoPointer.slide;

public class MinWindow {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }



    public static String minWindow(String s, String t) {
        char[] chars = s.toCharArray(), chart = t.toCharArray();
        int m = s.length(), n = t.length();
        int[] hash = new int[128];
        for (char c : chart) {
            hash[c]--;
        }
        String res = "";
        for (int i = 0, j = 0, count = 0; i < m; i++) {
            hash[chars[i]]++;
            if (hash[chars[i]] <= 0) {
                count++;
            }
            while (count == n && hash[chars[j]] > 0) {
                hash[chars[j++]]--;
            }
            if (count == n)
                if (res.equals("") || res.length() > i - j + 1)
                    res = s.substring(j, i + 1);
        }
        return res;
    }
}
