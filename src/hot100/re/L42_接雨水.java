package hot100.re;

public class L42_接雨水 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, res = 0;
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if (height[left] < height[right]) {
                res += leftMax - height[left++];
            } else {
                res += rightMax - height[right--];
            }
        }
        return res;
    }
}
