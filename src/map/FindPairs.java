package map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindPairs {
    public static void main(String[] args) {
        System.out.println(findPairs(new int[] {3,1,4,1,5},2));
        System.out.println(findPairs(new int[] {1,2,3,4,5},1));
    }


    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int pre = nums[i] - k;
            if (set.contains(pre)) {
                map.put(nums[i], pre);
            }
            set.add(nums[i]);
        }
        return map.entrySet().size();
    }
}
