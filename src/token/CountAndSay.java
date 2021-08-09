package token;

public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            s = describe(s);
        }
        return s;

    }

    public String describe(String s) {
        StringBuilder res = new StringBuilder();
        if (s.length() == 1) {
            res.append("1");
            res.append(s);
        }
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
            } else {
                res.append(count).append(s.charAt(i - 1));
                count = 1;
            }
            if (i == s.length() - 1) {
                res.append(count).append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
