package math;

public class Reverse {

    public static void main(String[] args) {
        System.out.println(reverse(-1230));
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int temp = x % 10;
            x /= 10;
            res = res * 10 + temp;
        }
        return res;
    }
}
