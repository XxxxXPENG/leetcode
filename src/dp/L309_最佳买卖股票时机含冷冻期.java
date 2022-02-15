package dp;

public class L309_最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        //买入股票
        int f0 = -prices[0];
        //卖出，冷冻期
        int f1 = 0;
        //卖出，非冷冻
        int f2 = 0;
        for (int i = 1; i < len; i++) {
            int newF0 = Math.max(f0, f2 - prices[i]);
            int newF1 = f0 + prices[i];
            int newF2 = Math.max(f1, f2);
            f0 = newF0;
            f1 = newF1;
            f2 = newF2;
        }
        return Math.max(f1, f2);

    }
}
