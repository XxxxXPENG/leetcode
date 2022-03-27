package week.wk8;

import java.util.*;
import java.util.stream.Collectors;

public class L5268_找出两数组的不同 {
    public static void main(String[] args) {
        L5268_找出两数组的不同 a = new L5268_找出两数组的不同();
        System.out.println(a.findDifference(new int[]{1,2,3,3},new int[]{1,1,2,2}));
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int num : set1) {
            if (!set2.contains(num)) {
                list1.add(num);
            }
        }
        for (Integer num : set2) {
            if (!set1.contains(num)) {
                list2.add(num);
            }
        }
        ans.add(list1);
        ans.add(list2);
        return ans;
    }
}
