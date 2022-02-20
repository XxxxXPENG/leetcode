package week.wk4;

public class L6012_统计各位数字之和为偶数的整数个数 {
    public static void main(String[] args) {
        L6012_统计各位数字之和为偶数的整数个数 a = new L6012_统计各位数字之和为偶数的整数个数();
        System.out.println(a.countEven(4));
    }


    public int countEven(int num) {
        int res = 0;
        for (int i = 2; i <= num ; i++) {
            if (isEven(i)) {
                res++;
            }
        }
        return res;
    }

    public boolean isEven(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum % 2 == 0;
    }
}
