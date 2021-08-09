package token;

public class CheckRecord {

    public static void main(String[] args) {
        System.out.println(checkRecord("LLLALL"));
    }

    public static boolean checkRecord(String s) {
        int a = 0, l = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                a++;
            }
        }
        char pre = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (pre == 'L' && s.charAt(i) == 'L') {
                l++;
                if(l > 1){
                    break;
                }
            } else {
                l = 0;
            }
            pre = s.charAt(i);
        }
        return a <= 1 && l <= 1;
    }
}
