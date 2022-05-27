package hot100.re2;

public class L121_买卖股票的最佳时机 {
    public static void main(String[] args) {
        L121_买卖股票的最佳时机 a = new L121_买卖股票的最佳时机();
        System.out.println(a.maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        int max = 0, start = prices[0];
        for (int price : prices) {
            start = Math.min(start, price);
            max = Math.max(max, price - start);
        }
        return max;
    }
}
