package week.wk7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L6031_找出数组中的所有K近邻下标 {
    public static void main(String[] args) {
        L6031_找出数组中的所有K近邻下标 a = new L6031_找出数组中的所有K近邻下标();
        System.out.println(a.findKDistantIndices(new int[]{3,4,9,1,3,9,5},9,1));
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int start = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == key) {
                start = Math.max(start, i - k);
                int end = Math.min(len-1, i + k);
                while (start <= end) {
                    res.add(start++);
                }
            }
        }
        return res;
    }


    public List<Integer> findKDistantIndices2(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (key == nums[i]) {
                list.add(i);
            }
        }
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (Integer index : list) {
            int start = index - k >= 0 ? index - k : 0;
            int end = index + k < len ? index + k : len-1;
            for (int i = start; i <= end; i++) {
                set.add(i);
            }
        }
        List<Integer> res = new ArrayList<>(set);
        res.sort((a, b) -> a - b);
        return res;
    }
}
