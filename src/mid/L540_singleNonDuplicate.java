package mid;

public class L540_singleNonDuplicate {

    public static void main(String[] args) {
        L540_singleNonDuplicate l = new L540_singleNonDuplicate();
        System.out.println(l.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }

    /**
     * 如果单元素在偶数索引mid后，则mid和mid+1相等
     * 反之亦然
     * @param nums
     * @return
     */
    public int singleNonDuplicate2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            //偶数为mid和后一位相等，则答案在右区间
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }


    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((mid - 1 >= 0 && nums[mid - 1] == nums[mid]) || (mid+1 < nums.length && nums[mid+1]==nums[mid])) {
                //左区间为奇数，则答案在左
                if (mid % 2 == 1) {
                    right = mid-1;
                } else {
                    left = mid + 2;
                }
            } else {
                boolean notMid = mid + 1 < nums.length && nums[mid + 1] == nums[mid];
                return notMid ? nums[mid-1] : nums[mid];
            }
        }
        return nums[left];
    }
}
