package math;

public class IsUgly {

    public static void main(String[] args) {
        System.out.println(isUgly(6));
        System.out.println(isUgly(8));
        System.out.println(isUgly(1));
    }

    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] nums = {2, 3, 5};
        for (int num : nums) {
            while (n % num == 0) {
                n /= num;
            }
        }
        return n == 1;
    }
}
