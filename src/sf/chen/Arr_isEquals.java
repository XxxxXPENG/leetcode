package sf.chen;

/**
 * 输入整数数组和n
 * 判断是否有连续的序列 和为n
 */
public class Arr_isEquals {
    public static void main(String[] args) {
        int[] arr = {5,2,1,3,4,6};
        int[] arr2 = {1,2,4,5,6};
        System.out.println(judge(arr2,10));
    }

        /**想想别的办法*/
//    public static boolean judge2(int[] arr,int n){
//        for (int i = 0; i < arr.length; i++){
//            int sum = 0;
//            for(int j = i; j < arr.length; j++ ){
//                sum += arr[j];
//                if(sum == n) return true;
//            }
//        }
//    }

    public static boolean judge(int[] arr,int n){
        int sum = 0;
        for (int i = 0; i < arr.length; i++ ){
            if(sum == n){
                return true;
            }
            sum = 0; //重新累加
            int j = i;//复制一份，保留原来i的位置
            while(sum < n){
                sum += arr[j];
                if(j < arr.length - 1){
                    j++;
                }else{
                    break;
                }
            }
        }
        return false;
    }
}
