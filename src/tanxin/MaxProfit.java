package tanxin;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int pre = prices[0];
        int max = 0;
        for (int i = 1; i <prices.length ; i++) {
            if (prices[i] < pre) {
                pre = prices[i];
            } else {
                max = Math.max(max, prices[i] - pre);
            }
        }
        return max;
    }
}
