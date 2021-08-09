package tanxin;

import java.util.Arrays;

public class ArrayPairSum {
    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{6,2,6,5,1,2}));
    }

    public static int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            sum += Math.min(nums[i] , nums[++i]);
        }
        return sum;
    }
}
