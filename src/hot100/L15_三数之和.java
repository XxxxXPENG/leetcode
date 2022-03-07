package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15_三数之和 {
    public static void main(String[] args) {
        L15_三数之和 a = new L15_三数之和();
        System.out.println(a.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        //先定下一个数，然后另外两个数使用双指针遍历
        for (int i = 0; i < len; i++) {
            int left = i+1, right = len - 1;
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;

    }
}
