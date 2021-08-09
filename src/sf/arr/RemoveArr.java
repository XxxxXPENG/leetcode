package sf.arr;

import java.util.ArrayList;

public class RemoveArr {
    public static void main(String[] args) {
        int[] arr = { 1,1,2,3,1,1,4,2,2,1};
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length - 1; j++){
                if(arr[i] == arr[j]){
                    break;//重复则去除
                }
                res.add(arr[i]);//添加完跳出循环，防止多次
                break;
            }
        }
        for (int i = 0; i < res.size(); i++){
            System.out.print(res.get(i));
        }
    }
}
