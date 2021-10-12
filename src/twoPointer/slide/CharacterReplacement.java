package twoPointer.slide;

public class CharacterReplacement {
    public static void main(String[] args) {
//        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA",1));
    }

    private static int[] sCnt = new int[26];

    public static int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        int maxLen = 0;
        char[] chars = s.toCharArray();
        int[] sCnt = new int[26];
        int left = 0,right;
        for (right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            sCnt[index]++;
            maxLen = Math.max(maxLen, sCnt[index]);
            if (right - left + 1 > maxLen + k) {
                sCnt[chars[left] - 'A']--;
                left++;
            }
        }
        return right - left;
    }
}
