package hot100.re7;

public class L75_颜色分类 {
    public void sortColors(int[] nums) {
        int p = 0,len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p] = tmp;
                p++;
            }
        }
        for (int i = p; i < len; i++) {
            if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p] = tmp;
                p++;
            }
        }
    }
}
