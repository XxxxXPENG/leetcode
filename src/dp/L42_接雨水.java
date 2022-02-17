package dp;

public class L42_接雨水 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int res = 0;
        while (left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            //如果左侧矮，则将左侧最大值与当前最测值高度差得出雨水值
            if (height[left] < height[right]) {
                res += maxLeft - height[left];
                left++;
            } else {
                res += maxRight - height[right];
                right--;
            }
        }
        return res;
    }
}
