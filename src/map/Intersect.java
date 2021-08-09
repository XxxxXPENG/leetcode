package map;

import java.util.Arrays;

public class Intersect {

    public static void main(String[] args) {

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[Math.min(len1, len2)];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                res[index++] = nums1[index1];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }
}
