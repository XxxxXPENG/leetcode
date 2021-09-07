package tanxin.math;

public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(2));
    }

    /**
     * 将n拆分为尽可能多的3，2
     *
     * @param n
     * @return
     */
    public static int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a-1) * 4;
        }
        return (int) Math.pow(3, a) * 2;
    }
}
