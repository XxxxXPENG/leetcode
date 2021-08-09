package map;

import java.util.HashMap;
import java.util.Map;

public class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index = (index + nums[i]) % k;
            if (map.containsKey(index)) {
                int preIndex = map.get(index);
                if (preIndex - i >= 2) {
                    return true;
                }
            } else {
                map.put(index, i);
            }
        }
        return false;
    }
}
