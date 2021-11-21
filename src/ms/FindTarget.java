package ms;

import java.util.Arrays;

public class FindTarget {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(find(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(find(new int[]{0, 2, 3, 5, 11, 15}, 14)));
    }

    public static int[] find(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int len = nums.length;
        for (int left = 0, right = len - 1; left < right; ) {
            if (nums[left] == nums[right]) {
                continue;
            }
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
