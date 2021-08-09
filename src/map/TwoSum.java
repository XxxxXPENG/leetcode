package map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));
    }


        public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
    
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i], list);
            } else {
                map.put(nums[i], Arrays.asList(i));
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int temp = target - entry.getKey();
            if (map.containsKey(temp)) {
                if (temp == entry.getKey() && entry.getValue().size() > 1) {
                    res[0] = entry.getValue().get(0);
                    res[1] = entry.getValue().get(1);
                    return res;
                } else {
                    res[0] = entry.getValue().get(0);
                    res[1] = map.get(temp).get(0);
                    return res;
                }
            }
        }
        return new int[]{};
    }
}
