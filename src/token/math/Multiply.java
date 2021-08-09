package token.math;

import java.util.ArrayList;
import java.util.List;

public class Multiply {

    public static void main(String[] args) {

        System.out.println(add("111","23"));

        System.out.println(multiply("2", "3"));
        System.out.println(multiply("456","123"));
        System.out.println(multiply("123","456"));

    }

    public static String multiply(String num1, String num2) {
        List<String> list = new ArrayList<>();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = num2.length() - 1; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int temp = a * b + carry;
                carry = temp / 10;
                sb.append(temp % 10);
            }
            if (carry != 0) {
                sb.append(carry);
            }
            list.add(sb.reverse().toString());
        }

        String res = list.get(0);
        int carry = 10;
        for (int i = 1; i < list.size(); i++) {
            String temp = String.valueOf(carry).substring(1);
            String str2 = list.get(i) + temp;
            carry = carry * 10;
            res = add(res, str2);
        }
        if(res.charAt(0)=='0') return 0+"";
        return res;
    }


    public static String add(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int aNum = i >= 0 ? a.charAt(i) - '0' : 0;
            int bNum = j >= 0 ? b.charAt(j) - '0' : 0;
            int temp = aNum + bNum + carry;
            carry = temp > 9 ? 1 : 0;
            res.append(temp % 10);
        }
        if (carry != 0) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}
