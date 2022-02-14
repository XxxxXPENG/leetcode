package dp;

public class L122_买卖股票的最佳时机II {
    public static void main(String[] args) {
        L122_买卖股票的最佳时机II a = new L122_买卖股票的最佳时机II();
        System.out.println(a.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }
}
