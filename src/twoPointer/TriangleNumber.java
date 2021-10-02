package twoPointer;

import java.util.Arrays;

public class TriangleNumber {
    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2,2,3,4}));
    }

    public static int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1, k = 0; k < j; j--) {
                while (k < j && nums[k] + nums[j] <= nums[i]) k++;
                ans += j - k;
            }
        }
        return ans;

    }
}
