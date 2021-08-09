package token;

public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                sb.append(Character.toLowerCase(c));
                sb.append(c);
            }
        }
        String str = sb.toString();
        System.out.println(str);

        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if ((str.charAt(left) != str.charAt(right))
                    && Math.abs(str.charAt(left) - str.charAt(right)) != ('a'-'A') ) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
