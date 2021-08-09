package arr;

import java.util.Arrays;

public class MinMoves {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            count += nums[i] - nums[0];
        }
        return count;
    }

    public void addExceptMax(int[] nums){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int d = max - min;
        boolean flag = false;
        //每次让除了最大值外的所有数组元素加n
        for (int num : nums) {
            if(!flag && num == max){
                flag = true;
                continue;
            }
            num += d;
        }
    }
}
