package dp.pack;

//有 N 件物品和一个容量是 C 的背包。每件物品有且只有一件。
//
//第 i 件物品的体积是 v[i]，价值是w[i] 。
public class MaxValue1 {

    public int maxValue(int N, int C, int[] v, int[] w) {
        int[] dp = new int[C + 1];
        for (int i = 0; i < N; i++) {
            for (int j = C; j >= v[i]; j--) {
                //不选
                int x = dp[j];
                //选
                int y = dp[j - v[i]] + w[i];
                dp[i] = Math.max(x, y);
            }
        }
        return dp[C];
    }
}
