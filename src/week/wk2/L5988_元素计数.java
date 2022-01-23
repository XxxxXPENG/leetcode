package week.wk2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L5988_元素计数 {
    public int countElements(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(nums);
        int len = nums.length;
        int maxCount = map.get(nums[len - 1]);
        int minCount = map.get(nums[0]);
        if(nums[len - 1] == nums[0]){
            return 0;
        }
        return len - maxCount - minCount;
    }
}
