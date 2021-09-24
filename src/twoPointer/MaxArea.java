package twoPointer;

/**
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，
 * 容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class MaxArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{4, 3, 2, 1, 4}));
    }


    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1, res = 0;
        while (left < right) {
            res = height[left] > height[right] ?
                    Math.max(res, (right - left) * height[left++])
                    : Math.max(res, (right - left) * height[right--]);
        }
        return res;
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int width = right - left;
            int temp = Math.min(leftHeight, rightHeight) * width;
            maxArea = Math.max(maxArea, temp);
            //选择较短边，向内移动
            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;


    }
}
