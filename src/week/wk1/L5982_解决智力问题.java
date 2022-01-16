package week.wk1;

public class L5982_解决智力问题 {
    public long mostPoints2(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n-1; i >= 0; i--) {
            int[] num = questions[i];
            int j = i + num[1] + 1;
            //如果选择了，则跳到第j题
            dp[i] = Math.max(dp[i + 1], num[0] + dp[j < n ? j : 0]);
        }
        return dp[0];

    }



}
