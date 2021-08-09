package token;

import java.util.ArrayList;
import java.util.List;

public class SolveEquation {
    public String solveEquation(String equation) {
        String[] lr = equation.split("=");
        int lhs = 0, rhs = 0;
        for (String x : breakIt(lr[0])) {
            if (x.contains("x")) {
                lhs += Integer.parseInt(coeff(x));
            } else {
                rhs -= Integer.parseInt(x);
            }
        }

        for (String x : breakIt(lr[1])) {
            if (x.contains("x")) {
                lhs -= Integer.parseInt(coeff(x));
            } else {
                rhs += Integer.parseInt(x);
            }
        }

        if (lhs == 0) {
            if (rhs == 0) {
                return "Infinite solutions";
            } else {
                return "No Solution";
            }
        }
        return "x=" + rhs / lhs;
    }


    public static String coeff(String s) {
        if (s.length() > 1 && s.charAt(s.length() - 2) >= '0' && s.charAt(s.length() - 2) <= '9') {
           return s.replace("x", "");
        }
        return s.replace("x", "1");
    }


    public static List<String> breakIt(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (r.length() > 0) {
                    res.add(r.toString());
                }
                r = new StringBuilder(s.charAt(i) + "");
            } else {
                r.append(s.charAt(i));
            }
        }
        res.add(r.toString());
        return res;
    }
}
