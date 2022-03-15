package hot100;

public class L33_搜索旋转排序数组 {

    public static void main(String[] args) {
        L33_搜索旋转排序数组 a = new L33_搜索旋转排序数组();
        System.out.println(a.search(new int[]{3,1},1));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //左段
            if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[nums.length - 1] && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
