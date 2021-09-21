package twoPointer;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum2(new int[]{-1,0,1,2,-1,-4}));
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (cur > 0) {
                return res;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int temp = cur + nums[left] + nums[right];
                if (temp == 0) {
                    List<Integer> list = Arrays.asList(cur, nums[left], nums[right]);
                    res.add(list);
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (temp < 0) {
                    left++;
                }else{
                    right--;
                }

            }
        }
        return res;
    }

















    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int cur = nums[i];
            int left = i + 1, right = len-1;
            while (left < right) {
                int temp = nums[left] + nums[right] + cur;
                if (temp == 0) {
                    List<Integer> list = Arrays.asList(cur, nums[left], nums[right]);
                    res.add(list);
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (temp < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
