package hot100;

public class L152_乘积最大子数组 {
    public static void main(String[] args) {
        L152_乘积最大子数组 a = new L152_乘积最大子数组();
        System.out.println(a.maxProduct(new int[]{2, 3, -2, 4}));
    }

    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, max = 1, min = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min ;
                min = temp;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
            res = Math.max(max, res);
        }
        return res;
    }
}
