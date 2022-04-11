package hot100;

public class L121_买卖股票的最佳时机 {
    public static void main(String[] args) {
        L121_买卖股票的最佳时机 a = new L121_买卖股票的最佳时机();
        System.out.println(a.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }


    public int maxProfit(int[] prices) {
        int max = 0;
        if (prices == null || prices.length == 0) {
            return max;
        }
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            }
            max = Math.max(max, prices[i] - buy);
        }
        return max;
    }
}
