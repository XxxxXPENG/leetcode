package arr;

import java.util.Arrays;

public class FindErrorNums {
    public static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int dup = -1, missing = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                dup = nums[i];
            } else if (nums[i] - nums[i - 1] > 1) {
                missing = nums[i - 1] + 1;
            }
        }
//        return new int[]{dup,missing};
        return new int[] {dup, nums[nums.length - 1] != nums.length ? nums.length : missing};

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1,2,2,4})));
    }
}
