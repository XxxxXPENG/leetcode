package sf.arr;

/**
 * 一个数组的元素都是0-n之内，找出数组的第一个重复元素
 * */
public class FirstRe {
    public static void main(String[] args) {
        int[ ] arr = {1,2,3,4,5,6,7,5};
        System.out.println(arr.length/2-1);
        System.out.println("review="+re2(arr));
    }
    public static int re(int[ ] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j])
                    return arr[j];
            }
        }
        return -1;
    }
    public static int re2(int[ ] arr){
        for (int i = 0; i < arr.length; i++) {
            boolean flag = arr[i] <= arr.length;
            if(flag)
            arr[arr[i]] = arr[i] + arr.length;
            if(flag && arr[arr[i]] > 2*arr.length)
                return arr[i];
        }
        return -1;
    }
}
