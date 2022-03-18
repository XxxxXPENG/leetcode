package mid.re;

public class L162_寻找峰值 {

    public static void main(String[] args) {
        L162_寻找峰值 a = new L162_寻找峰值();
        System.out.println(a.findPeakElement2(new int[]{1,2,3,4,2}));
    }

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }

    public int findPeakElement2(int[] nums) {
        int len = nums.length, left = 0, right = len - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
                if (mid - 1 >= 0 && mid + 1 < len  && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (mid+1 < len && nums[mid+1] > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
        }
        return mid;
    }
}
