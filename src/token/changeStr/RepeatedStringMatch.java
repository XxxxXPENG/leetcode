package token.changeStr;


public class RepeatedStringMatch {

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abc","cabcabca"));
    }


    public static int repeatedStringMatch(String a, String b) {
        int count = 0;
        int len = b.length();
        StringBuilder sb = new StringBuilder();
        while (sb.length() <= len) {
            sb.append(a);
            count++;
            if (sb.indexOf(b) != -1) {
                return count;
            }
        }
        sb.append(a);
        count++;
        return sb.indexOf(b) != -1 ? count : -1;
    }


}
