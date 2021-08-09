package sf.chen;

import java.util.Scanner;

/**
 * 输入：[10,-10,1,2,3,4,-5,-23,3,7,-21]
 * 输出：10 1 4
 */
public class Arr_maxLength2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        maxLength(arr);
    }
    public static void maxLength(int[] arr){
        int sum = 0,tempSum = 0,begin = 0,tempBegin = 0,end = 0,tempEnd = 0;
        for (int i = 0; i < arr.length; i++){
            if(tempSum > 0){
                tempSum += arr[i];
                tempEnd = arr[i];
            }else{
                sum = arr[i];
                tempBegin = arr[i];
            }
            if(tempSum > sum ){
                sum = tempSum;
                begin = tempBegin;
                end = tempEnd;
            }
        }
        System.out.println(sum+" "+ begin +" " + end);
    }

    public static void maxLength2(int[] arr){
        int p1 = 0,p2 = 0;
        int sum = 0, maxSum = 0 , count = 0,maxCount = 0;
        for (int i = 0; i < arr.length; i++){
            if(sum > 0){
                sum += arr[i];
                count++;
            }else{
                sum = arr[i];
                p1 = i;
            }
            //有问题，可能不是最大的 但是最长
            if(sum > maxSum && count > maxCount ){
                maxCount = count;
                maxSum = sum;
                p2 = i;
            }
        }
        System.out.println(maxSum +" "+arr[p2-maxCount]+ " "+ arr[p2]);
    }
}
