package hot100;

public class L11_盛最多水的容器 {

    public static void main(String[] args) {
        L11_盛最多水的容器 a = new L11_盛最多水的容器();
        System.out.println(a.maxArea(new int[]{1,1}));
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int high = Math.min(height[left], height[right]);
        int res = (right - left ) * high;
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            high = Math.min(height[left], height[right]);
            res = Math.max(res, high * (right - left));

        }
        return res;
    }
}
