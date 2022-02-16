package dp;

public class L714_买卖股票的最佳时机含手续费 {

    public static void main(String[] args) {
        L714_买卖股票的最佳时机含手续费 a = new L714_买卖股票的最佳时机含手续费();
        System.out.println(a.maxProfit2(new int[]{1, 3, 2, 8, 4, 9},2));
    }

    public int maxProfit2(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        // (i,0) 代表持有股票
        dp[0][0] =  -prices[0];
        //卖出时的最大利润
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            //持有股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] );
            //卖出
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0] - fee);
        }
        return dp[len - 1][1];
    }




    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int buy = prices[0] + fee;
        int profile = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                profile += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profile;
    }
}
