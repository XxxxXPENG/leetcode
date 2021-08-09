package sf.chen;

import java.util.ArrayList;
import java.util.Arrays;

public class String_duplicate {
    public static void main(String[] args) {
        int[] arr = {1,6,8,3,7,9,2,7,2,4,4,3,3,1,5,3};
        int[] res = duplicate(arr);
        System.out.println(Arrays.toString(res));
    }



    public static int[] duplicate(int[] arr){
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> unique = new ArrayList<>();
        for(int i = 0; i  < arr.length;i++){
            if(!unique.contains(arr[i])){
                unique.add(arr[i]);
            }else{
                if(!res.contains(arr[i])){
                    res.add(arr[i]);
                }
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }
}
