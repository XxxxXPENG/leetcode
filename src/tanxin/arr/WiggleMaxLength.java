package tanxin.arr;

public class WiggleMaxLength {

    public static void main(String[] args) {
        System.out.println(wiggleMaxLength2(new int[]{3,3,3,2,5}));
    }

    public static int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int res = 1, len = nums.length;
        int pre = nums[1] - nums[0];
        for (int i = 2; i < len; i++) {
            int j = i;
            while (j + 1 < len && (nums[j + 1] - nums[j]) * pre < 0) {
                pre = nums[j + 1] - nums[j];
                j++;
                res++;
            }
            i = j;
        }
        return res;
    }


    public static int wiggleMaxLength2(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int res = 1, len = nums.length;
        int cur = 0, pre = 0;
        for (int i = 1; i < len; i++) {
            cur = nums[i] - nums[i - 1];
            if ((cur > 0 && pre <= 0) || (cur < 0 && pre >= 0)) {
                res++;
                pre = cur;
            }
        }
        return res;
    }

}
