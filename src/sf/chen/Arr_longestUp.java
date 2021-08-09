package sf.chen;

/**
 * 给定一个数组，输出连续递增最长 长度
 * 1 3 5 4 7
 * 3
 */
public class Arr_longestUp {
    public static void main(String[] args) {
        int[] arr = {1,3,5,4,7};  // 3 1 5 4 7
        System.out.println(longestUp(arr));
    }

    public static int maxLength(int[] arr){
        int maxLength = 1,length = 1;
        for (int i = 0; i < arr.length - 1 ; i++){
            if(arr[i + 1] > arr[i]) length++;
            else length = 1;
            maxLength = length > maxLength ? length : maxLength;
        }
        return maxLength;
    }
    public static int longestUp(int[] arr){
        int count = 0, count1 = 0;
        for (int i = 0; i < arr.length; i++){
            if(count < count1) count = count1;
            count1 = 0;
            for(int j = i; j < arr.length - 1; j++){
                if(arr[j + 1] > arr[j] ){
                    count1++;
                }
            }
        }
        return count;
    }
}
