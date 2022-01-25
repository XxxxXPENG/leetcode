package mid;

public class L81_搜索旋转排序数组II {
    public static void main(String[] args) {
        L81_搜索旋转排序数组II a = new L81_搜索旋转排序数组II();
        System.out.println(a.search(new int[]{1,0,1,1,1},0));


        // + 的优先级高于 >> ,故r3有问题
        int m = 2, n = 6;
        int r1 = m + (n - m) / 2;
        int r2 = m + ((n - m) >> 1);
        int r3 = m + (n - m) >> 1;
        System.out.println((n - m) >> 1);
        System.out.println(r1 + "," + r2 + "," + r3);
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) /2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[left]) {
                left++;
                continue;
            }
            //左端
            if (nums[left] < nums[mid]) {
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
