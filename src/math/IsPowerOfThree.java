package math;

public class IsPowerOfThree {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));

        System.out.println(isPowerOfThree(45));
    }

    public static boolean isPowerOfThree(int n) {
        double temp = n;
        while (temp > 1) {
            temp /= 3;
        }
        return temp == 1;
    }
}
