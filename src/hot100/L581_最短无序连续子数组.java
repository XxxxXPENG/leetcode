package hot100;

public class L581_最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int left = - 1, right = -1;
        for (int i = 0; i < n; i++) {
            //右端最小值
            if (max > nums[i]) {
                right = i;
            } else {
                max = nums[i];
            }
            //左端最大值
            if (min < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                min = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;

    }
}
