package dp;

public class L518_零钱兑换II {
    public int change(int amount, int[] coins) {
        //定义dp[i] 为面值为i的组合数
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
