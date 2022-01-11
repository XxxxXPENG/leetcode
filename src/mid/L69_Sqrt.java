package mid;

public class L69_Sqrt {
    public static void main(String[] args) {
        L69_Sqrt a = new L69_Sqrt();
        System.out.println(a.mySqrt(8));
    }


    public int mySqrt(int x) {
        int left = 1, right = x / 2;
        while (left < right) {
            //向上取整
            int mid = left + (right - left + 1) / 2;
//           mid * mid  vs  x
//           2边同除mid也可正常比较，省去溢出问题
            int square = x / mid;
            if (mid > square) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
