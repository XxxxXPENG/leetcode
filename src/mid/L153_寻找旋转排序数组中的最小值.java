package mid;

public class L153_寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid+1;
            } else if(nums[mid] < nums[right]){
                right = mid;
            }
        }
        return nums[left];
    }
}
