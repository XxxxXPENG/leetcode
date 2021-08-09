package math;

public class LargestPalindrome {
    public int largestPalindrome(int n) {
        if(n == 1) return 9;
        long max = (long) (Math.pow(10, n) - 1);
        for (long i = max - 1; i > max / 10; i--) {
            String str = String.valueOf(i);
            long rev = Long.parseLong(str + new StringBuilder(str).reverse().toString());
            for (long x = max; x*x >= rev  ; x--) {
                if (rev % x == 0) return (int) (rev % 1337);
            }
        }
        return -1;
    }
}
