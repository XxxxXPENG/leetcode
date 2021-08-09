package sf.arr;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 *
 * Input:
 * {2, 3, 1, 0, 2, 5}
 *
 * Output:
 * 2
 */
public class Duplicate {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5};
        System.out.println(duplicate2(arr));

    }
    //方法二、
    public static int duplicate2(int[] arr){
        if(arr.length <=0 || arr == null){
            return -1;
        }
        for (int i = 0; i < arr.length; i++ ){
            //判断i元素的值是否等于i下标
            while(arr[i] != i){
                //如果发现arr[arr[i]]即下标为元素对应的值  那么就重复了
                if(arr[i] == arr[arr[i]]){
                    return arr[i];
                }
                swap(arr,i,arr[i]);//未发现则排序
            }
        }
        return -1;
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //方法一、这种做法看上去时间复杂度是N ,其实是 N²
    public static int duplicate(int[] arr){
        String str = "";
        for (int i = 0; i < arr.length; i++){
            str += arr[i];
        }
        for(int i = 0; i < str.length(); i++){
            if(str.indexOf( (char) arr[i]) == -1){
                return arr[i];
            }
        }
        return -1;
    }
}
