package hot100.re2;

public class L42_接雨水 {

    public static void main(String[] args) {
        L42_接雨水 a = new L42_接雨水();
        System.out.println(a.trap(new int[]{4,2,0,3,2,5}));
    }

    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        int leftMax = height[left], rightMax = height[right];
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            if (leftHeight < rightHeight) {
                leftMax = Math.max(leftHeight, leftMax);
                res += leftMax - leftHeight;
                left++;
            } else {
                rightMax = Math.max(rightHeight, rightMax);
                res += rightMax - rightHeight;
                right--;
            }
        }
        return res;
    }

}
