package map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        Set<Integer> res = new HashSet<>();
        set1.forEach(num1 -> set2.forEach(num2 -> {
            if (num1.equals(num2)) {
                res.add(num1);
            }
        }));
        int[] ans = new int[res.size()];
        int i = 0;
        for (int num : res) {
            ans[i++] = num;
        }
        return ans;
    }
}
