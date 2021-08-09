package sf.sort;

import java.util.Arrays;

public class MergeSort {
    /**
     * 归并排序：分2步走。
     * 第一步，分区。把数组分为左边部分和右边部分，让左右2边分别有序。
     * 第二步，归并。利用一个辅助数组N将左右两边的数字按顺序依次放入。
     * 最后再将这个辅助数组的值传递给原数组。
     * 时间复杂度： O(NlogN)
     * 空间复杂度：O(N)
     * @author LinXiaobo
     *
     */

    public static void main(String[] args) {
        int[] arr = {2,23,4,6,1};
        mergeSort(arr,0,arr.length-1); //右下标错了
        System.out.println(Arrays.toString(arr));
    }
    //一、先把数组拆分成单个
    public static void mergeSort(int[] arr,int l,int r){
        if(l == r){
            return;
        }
        int mid = l + ((r - l) >> 1);  //没加括号错了，>>的优先级和+-同级
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    //二、归并
    public static void merge(int[] arr,int l,int mid,int r){
        int p1 = l, p2 = mid+1;//p2赋值错了
        int i = 0;
        int[] temp = new int[r - l+ 1]; //不是arr的长度，每次都会变。错了
        while(p1 <= mid && p2 <= r ){
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            temp[i++] = arr[p1++];
        }
        while(p2 <= r){
            temp[i++] = arr[p2++];
        }
        for(i = 0; i < temp.length; i++){  //每次都会生成新的辅助数组，错了
            arr[l+i] = temp[i];  //错了
        }
    }
}
