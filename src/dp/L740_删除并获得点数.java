package dp;

public class L740_删除并获得点数 {
    public static void main(String[] args) {
        L740_删除并获得点数 a = new L740_删除并获得点数();
        System.out.println(a.deleteAndEarn(new int[]{8, 7, 3, 8, 1, 4, 10, 10, 10, 2}));
    }


    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int[] sum = new int[maxVal + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        int len = sum.length;
        int pre = sum[0], cur = Math.max(sum[0], sum[1]);
        for (int i = 2; i < len; i++) {
            int tmp = cur;
            cur = Math.max(cur, pre + sum[i]);
            pre = tmp;
        }
        return cur;
    }
}
