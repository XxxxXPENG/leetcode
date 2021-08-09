package token;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("2-5g-3-J",2));
    }

    public static String licenseKeyFormatting(String s, int k) {
        String str = s.replaceAll("-", "");
        str = str.toUpperCase();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
            count++;
            if (count % k == 0 && i != 0) {
                sb.append("-");
            }
        }
        return sb.reverse().toString();
    }
}
