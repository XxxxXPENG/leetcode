package mid;

public class L441_排列硬币 {
    public static void main(String[] args) {
        L441_排列硬币 a = new L441_排列硬币();
        System.out.println(a.arrangeCoins(5));
    }

    public int arrangeCoins(int n) {
        int left =1 ,right =n;
        while (left < right) {
            int mid = left + (right - left +1)/2;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
