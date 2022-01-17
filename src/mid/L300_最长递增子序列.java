package mid;

public class L300_最长递增子序列 {
    public static void main(String[] args) {
        L300_最长递增子序列 a = new L300_最长递增子序列();
        System.out.println(a.lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 1, n = nums.length;
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int left = 1, right = len, pos = 0;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        left = mid+1;
                    } else {
                        right = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
