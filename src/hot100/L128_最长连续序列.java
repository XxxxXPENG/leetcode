package hot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L128_最长连续序列 {
    public static void main(String[] args) {
        L128_最长连续序列 a = new L128_最长连续序列();
        int[] arr = new int[]{9,1,4,7,3,-1,0,5,8,-1,6};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(a.longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        //1.遍历set
        for (int num : set) {
            //2.如果是连续的则不遍历
            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(num + 1)) {
                    num++;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
