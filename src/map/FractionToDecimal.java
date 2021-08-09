package map;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1,3));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            sb.append("-");
        }
        long a = Math.abs(Long.valueOf(numerator));
        long b = Math.abs(Long.valueOf(denominator));
        sb.append(a/b);
        long remainder = a % b;
        if (remainder == 0) {
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / b);
            remainder %= b;

        }
        return sb.toString();
    }
}
