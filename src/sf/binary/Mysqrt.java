package sf.binary;

/**
 * r = mid - 1 / l = mid + 1
 * 这个mid数字太大或太小 , 减小范围
 */
public class Mysqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
    public static int mySqrt(int x) {
       if( x <= 1 ){
           return x;
       }
       int l = 1, r = x;
       int mid = 0;
       while(l <= r){
           mid = l + (r - l) / 2;
           // 如果使用 两数*，很容易导致溢出问题。 把参照值改为 sqrt = x / mid
           if(mid * mid == x){
               return mid;
           }else if(mid * mid > x){
               r = mid - 1;
           }else if(mid * mid < x){
               l = mid + 1;
           }
       }
       return r;
    }


    }
