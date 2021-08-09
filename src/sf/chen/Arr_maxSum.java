package sf.chen;

/**
 * [-2,1,-3,4,-1,2,1,-5,4]
 *
 * [4,-1,2,1]  ,6
 */
public class Arr_maxSum {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSum2(arr));
    }
    public static int maxSum2(int[] arr){
        int sum = arr[0] ,maxSum = sum;
        for (int i = 0; i < arr.length; i++){
            if(sum < 0){
                sum = arr[i];
            }else{
                sum+=arr[i];
            }
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }

    public static int maxSum(int[] arr){
        int maxSum = 0, sum = 0;
        boolean flag = false;
        if(arr == null || arr.length == 0) return 0;
        for (int i = 0; i < arr.length -1; i++){
            if( !flag && arr[i] > 0 && sum == 0 || arr[i] + arr[i + 1] > 0 ) {
                flag = true;
            }
            if( flag &&  (arr[i] > 0 || arr[i] + arr[i+1] > 0)  ) sum += arr[i] ;
            else {
                maxSum = Math.max(maxSum,sum);
                sum = 0;
                flag = false;
            }
        }
        return maxSum;
    }
}
