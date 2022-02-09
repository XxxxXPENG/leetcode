package dp;

public class L1137_第N个泰波那契数 {

    public static void main(String[] args) {
        L1137_第N个泰波那契数 a = new L1137_第N个泰波那契数();
        System.out.println(a.tribonacci(25));
    }

    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n <= 2) return 1;
        int n1 = 0, n2 = 1, n3 = 1, sum = 2;
        for (int i = 4; i <= n; i++) {
            n1 = n2;
            n2 = n3;
            n3 = sum;
            sum = n1 + n2 + n3;
        }
        return sum;
    }
}
