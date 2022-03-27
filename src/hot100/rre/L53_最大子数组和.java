package hot100.rre;

public class L53_最大子数组和 {

    public static void main(String[] args) {
        L53_最大子数组和 a = new L53_最大子数组和();
        System.out.println(a.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public int maxSubArray(int[] nums) {
        int sum = nums[0],max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
