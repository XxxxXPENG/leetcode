package map;

import java.util.*;

public class LongestConsecutive {

    public static void main(String[] args) {
        int[] arr = new int[]{100,4,200,1,3,2};
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        System.out.println(longestConsecutive(arr));
    }


    public static int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxCount = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentCount = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentCount++;
                }
                maxCount = Math.max(maxCount, currentCount);
            }
        }
        return maxCount;
    }

        public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.comparingInt(o -> o));
        int maxCount = 1, count = 1;
        int pre = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (pre == list.get(i) - 1) {
                count++;
            }
            if(pre != list.get(i) - 1 || i == list.size() - 1) {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
            pre = list.get(i);
        }
        return maxCount;
    }
}
