package hot100;

public class L42_接雨水 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        //左侧小则计算左侧高度差，并且移动左侧
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

    public static void main(String[] args) {
        L42_接雨水 a = new L42_接雨水();
        System.out.println(a.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
