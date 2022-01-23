package week.wk2;

import java.util.Arrays;

public class L5991_按符号重排数组 {

    public static void main(String[] args) {
        L5991_按符号重排数组 a = new L5991_按符号重排数组();
        System.out.println(Arrays.toString(a.rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})));
    }


    public int[] rearrangeArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int len = nums.length;
        int[] res = new int[len];
        int[] big = new int[len / 2];
        int[] small = new int[len / 2];
        int i = 0, j = 0;
        for (int num : nums) {
            if (num > 0) {
                big[i++] = num;
            } else {
                small[j++] = num;
            }
        }
        for (int k = 0; k < len; k++) {
            if (k % 2 == 0) {
                res[k] = big[k / 2];
            } else {
                res[k] = small[k / 2];
            }
        }
        return res;
    }
}
