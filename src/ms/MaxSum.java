package ms;

/**
 * [-2,1,-3,4,-1,2,1,-5,4]
 * 6 , [4,-1,2,1]
 */
public class MaxSum {

    public static void main(String[] args) {
        System.out.println(getMaxSum(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int getMaxSum(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int res = nums[0];
        int sum = res;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
