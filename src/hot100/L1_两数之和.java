package hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L1_两数之和 {

    public static void main(String[] args) {
        L1_两数之和 a = new L1_两数之和();
        System.out.println(Arrays.toString(a.twoSum(new int[]{3, 3}, 6)));
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        for(int num : nums){
            if(map.containsKey(target-num) && target-num != num){
                return new int[]{map.get(num),map.get(target-num)};
            }
        }
        return new int[]{};
    }
}
