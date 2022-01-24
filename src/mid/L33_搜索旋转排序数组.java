package mid;

public class L33_搜索旋转排序数组 {
    public static void main(String[] args) {
        L33_搜索旋转排序数组 a = new L33_搜索旋转排序数组();
        System.out.println(a.search2(new int[]{4,5,6,7,0,1,2},4));
    }

    public int search2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid =  (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //左侧
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //右侧
                if (nums[mid] < target && nums[n - 1] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


}
