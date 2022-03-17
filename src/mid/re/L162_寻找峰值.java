package mid.re;

public class L162_寻找峰值 {

    public static void main(String[] args) {
        L162_寻找峰值 a = new L162_寻找峰值();
        System.out.println(a.findPeakElement(new int[]{1,2}));
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


            /*if (mid - 1 >= 0 && mid + 1 <= nums.length - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid] > nums[mid - 1] && nums[mid + 1] > nums[mid]) {
                    left = mid+1;
                } else if (nums[mid] < nums[mid - 1] && nums[mid + 1] < nums[mid]) {
                    right = mid - 1;
                }
            }*/

        }
        return left;
    }
}
