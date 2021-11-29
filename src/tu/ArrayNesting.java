package tu;

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int d = 10000000;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i], count = 0;
            if (nums[i] < d) {
                while (nums[start] < d) {
                    int temp = start;
                    count++;
                    start = nums[start];
                    nums[temp] = nums[temp] + d;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
