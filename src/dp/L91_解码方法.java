package dp;

public class L91_解码方法 {

    public static void main(String[] args) {
        L91_解码方法 a = new L91_解码方法();
        System.out.println(a.numDecodings2("226"));
    }


    public int numDecodings(String s) {
        int len = s.length();
        //让下标从1开始
        s = " " + s;
        char[] arr = s.toCharArray();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            int a = arr[i] - '0', b = (arr[i - 1] - '0') * 10 + a;
            if (a > 0 && a <= 9) {
                dp[i] = dp[i - 1];
            }
            if (b > 9 && b <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }

    //常量空间
    public int numDecodings2(String s) {
        int[] dp = new int[3];
        dp[0] = 1;
        int len = s.length();
        s = " " + s;
        char[] arr = s.toCharArray();
        for (int i = 1; i <= len; i++) {
            dp[i % 3] = 0;
            int a = arr[i] - '0', b = (arr[i - 1] - '0') * 10 + a;
            if (a > 0 && a <= 9) {
                dp[i % 3] = dp[(i - 1) % 3];
            }
            if (b > 9 && b <= 26) {
                dp[i % 3] += dp[(i - 2) % 3];
            }
        }
        return dp[len % 3];
    }

}
