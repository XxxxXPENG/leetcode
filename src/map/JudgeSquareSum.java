package map;

public class JudgeSquareSum {

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(1));
    }

    public static boolean judgeSquareSum(int c) {
        for (long a = 0; a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b ==(int) b) {
                return true;
            }
        }
        return false;
    }
}
