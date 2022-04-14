package hot100.re;

public class L121_买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int res = 0, buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            //先处理买点
            if (prices[i] < buy) {
                buy = prices[i];
            }else {
                res = Math.max(res, prices[i] - buy);
            }
        }
        return res;
    }
}
