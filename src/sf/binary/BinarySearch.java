package sf.binary;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(binarySearch(3,arr));
    }

    public static int binarySearch(int key,int[] arr){
        int l = 0, r = arr.length - 1;
        while( l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] == key){
                return mid;
            }else if(key > arr[mid]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
    //二分法变种

}
