package sf.sort.review;

import java.util.Arrays;

public class MergerSort {
//    public static void mergerSort(int[] arr,int l,int r){
//        if(l == r){
//            return;
//        }
//        int mid = l + ((r-l) >> 1);
//        mergerSort(arr,l,mid);
//        mergerSort(arr,mid+1,r);
//        merger(arr,l,mid,r);
//    }
//
//    private static void merger(int[] arr, int l, int mid, int r) {
//        int i = 0;
//        int p1 = l, p2 = mid + 1;
//        int[] temp = new int[r-l+1];
//        while(p1 <= mid && p2 <= r){
//            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
//        }
//        while(p1 <= mid){
//            temp[i++] = arr[p1++];
//        }
//        while(p2 <= r){
//            temp[i++] = arr[p2++];
//        }
//        for (i = 0; i < temp.length; i++){
//            arr[l + i] = temp[ i];
//        }
//    }
    public static void main(String[] args) {
        int[] arr = {1,5,2,0};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int mid = l + ((r-l) >> 1);
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int p1 = l, p2 = mid + 1;
        int i = 0;
        int[] temp = new int[r-l+1];
        while(p1 <= mid && p2 <= r){
            temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            temp[i++] = arr[p1++];
        }
        while(p2 <= r){
            temp[i++] = arr[p2++];
        }
        for (i = 0; i < temp.length; i++){
            arr[l+i] = temp[i];
        }
    }

}
