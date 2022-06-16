package mid;

import java.util.Arrays;

public class L719_找出第K小的数对距离 {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length, left = 0, right = nums[len - 1],count=0;
        while (left <= right) {
            int mid = (left + right) / 2;
            for (int i = 0, j = 0; i < len; i++) {
                while (nums[i] - nums[j] > mid) {
                    j++;
                }
                count += i-j;
            }
            if (count >= k) {
                right = mid - 1;
            } else {
                left= mid+1;
            }
        }
        return left;
    }
}
