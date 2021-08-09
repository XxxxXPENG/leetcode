package token.math;

public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010","1011"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int pre = 0;
        int len = Math.max(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            int num1 = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            int num2 = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            int temp = num1 + num2 + pre;
            pre = temp > 1 ? 1 : 0;
            res.append(temp % 2);
        }
        if (pre > 0) {
            res.append(pre);
        }
        return res.reverse().toString();
    }
}
