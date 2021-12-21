package backTrack;

public class IntegerReplacement {
    public static void main(String[] args) {
        System.out.println(integerReplacement(8));
    }

    public static int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                count++;
                n /= 2;
            } else if (n % 4 == 1) {
                //余数为1, 则最优为-1再/2
                count += 2;
                n /= 2;
            } else {
                //余数为3，最优为+1再/2
                count += 2;
                if (n == 3) {
                    n = 1;
                } else {
                    n = n/2+1;
                }
            }
        }
        return count;
    }
}
