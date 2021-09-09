package tanxin.stack;

import java.util.*;

public class NextGreaterElement {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement2(new int[]{4,1,2},new int[]{1,3,4,2})));
    }

    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peekLast() < num) {
                map.put(stack.removeLast(), num);
            }
            stack.add(num);
        }

        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        int len = nums2.length;
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            int j = map.get(num);
            while (j < len) {
                if (nums2[j] > num) {
                    res[i] = nums2[j];
                    break;
                }
                j++;
                if (j == len) {
                    res[i] = -1;
                }
            }
        }
        return res;
    }
}
