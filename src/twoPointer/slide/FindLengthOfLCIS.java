package twoPointer.slide;

public class FindLengthOfLCIS {
    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1,3,5,4,2,3,4,5}));
    }

    public static int findLengthOfLCIS2(int[] nums) {
        int res = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }

        public static int findLengthOfLCIS(int[] nums) {
        int res = 1,temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                temp++;
                res = Math.max(res, temp);
            } else {
                temp = 1;
            }
        }
        return res;
    }
}
