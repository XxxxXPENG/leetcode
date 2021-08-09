package sf.sort.review;

import java.util.Arrays;

public class Dui_sort {
    public static void main(String[] args) {
        int[] nums = {16,7,3,20,17,8 };
        dui_sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void dui_sort(int[] arr){
        for(int i = arr.length/2-1;i >= 0; i--){
            headAdjust(arr,arr.length,i);//从i开始
        }
        for(int i = arr.length-1;i >= 1; i--){
            int temp = arr[0];
            arr[0] = arr[i];
             arr[i] = temp;
             headAdjust(arr,i,0);
        }
    }


    /**
     *
     * @param arr   要排序的数组
     * @param len   排序到哪结束
     * @param i     从哪开始
     */
    public static void headAdjust(int[] arr,int len,int i){
        int k = i,index = 2*i+1,temp = arr[i];
        while(index < len){
            //选择较大子节点
            if(index + 1 < len){
                if(arr[index + 1] > arr[index])
                    index = index + 1;
            }
            //交换父节点和子节点
            if(temp < arr[index]){
                arr[k] = arr[index];
                k = index;
                index = 2*k+1;
            }else
                break;
        }
        arr[k] = temp;  // ?
    }
}
