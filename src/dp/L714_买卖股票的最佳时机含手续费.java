package dp;

public class L714_买卖股票的最佳时机含手续费 {
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
