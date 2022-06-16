package day;

import java.util.Arrays;

public class L532_数组中的kDiff数对 {

    public static void main(String[] args) {
        L532_数组中的kDiff数对 a = new L532_数组中的kDiff数对();
        System.out.println(a.findPairs(new int[]{1, 2, 3, 4, 5}, 0));
    }


    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, count = 0;
        for (int i = 0, j = 0; i < n; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                while (j < n && (nums[j] - nums[i]) < k || j <= i) {
                    j++;
                }
                if (j < n && (nums[j]) - nums[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
