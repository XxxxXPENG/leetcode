package dp;

public class L1014_最佳观光组合 {
    public static void main(String[] args) {
        L1014_最佳观光组合 a = new L1014_最佳观光组合();
        System.out.println(a.maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
    }

    public int maxScoreSightseeingPair(int[] values) {
        int res = 0, max = values[0];
        for (int i = 1; i < values.length; i++) {
            res = Math.max(res, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }
        return res;
    }
}
