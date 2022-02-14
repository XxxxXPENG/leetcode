package dp;

public class L121_买卖股票的最佳时机 {
    public static void main(String[] args) {
        L121_买卖股票的最佳时机 a = new L121_买卖股票的最佳时机();
        System.out.println(a.maxProfit(new int[]{7,1,0}));
    }

    public int maxProfit(int[] prices) {
        int max = 0, pre = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > pre) {
                max = Math.max(max, prices[i] - pre);
            } else {
                pre = prices[i];
            }
        }
        return max;

    }
}
