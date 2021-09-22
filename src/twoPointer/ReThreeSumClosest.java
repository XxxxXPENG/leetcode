package twoPointer;

import java.util.Arrays;

public class ReThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest2(new int[]{1,1,1,1}, 0));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 10000;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = cur + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }


    public static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 10000;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int cur = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = cur + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
