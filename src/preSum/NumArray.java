package preSum;

public class NumArray {
    int[] sums;

    public NumArray(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }
    //保证 o(1) 内完成
    public int sumRange(int i, int j) {
        return sums[j] - sums[i];
    }

}
