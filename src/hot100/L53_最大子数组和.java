package hot100;

public class L53_最大子数组和 {
    public static void main(String[] args) {
        L53_最大子数组和 a = new L53_最大子数组和();
        System.out.println(a.maxSubArray(new int[]{5,4,-1,7,8}));
    }


    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0, max = nums[0];
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
