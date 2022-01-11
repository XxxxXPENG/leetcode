package mid;

public class L367_有效的完全平方数 {
    public static void main(String[] args) {
        L367_有效的完全平方数 a = new L367_有效的完全平方数();
        System.out.println(a.isPerfectSquare(808201));
    }

    public boolean isPerfectSquare(int num) {
        int left = 1, right = num/2;
        while (left < right) {
            int mid = left + (right-left)/2;
            //整数溢出问题
            long square = (long) mid * mid;
            if (square >= num) {
                //在左区间
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left*left==num;
    }
}
