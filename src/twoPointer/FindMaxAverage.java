package twoPointer;

public class FindMaxAverage {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{0,4,0,3,2},1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }
}
