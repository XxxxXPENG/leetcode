package twoPointer;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 100000;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }

                if (sum > target) {
                    int rightTemp = right - 1;
                    while (left < rightTemp && nums[right] == nums[rightTemp]) {
                        rightTemp--;
                    }
                    right = rightTemp;
                }else {
                    int leftTemp = left + 1;
                    while (leftTemp < right && nums[left] == nums[leftTemp]) {
                        leftTemp++;
                    }
                    left = leftTemp;
                }

            }
        }
        return best;
    }
}
