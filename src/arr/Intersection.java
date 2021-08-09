package arr;

import java.util.Arrays;

public class Intersection {
    //取交集
    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] res = new int[len];
        int index = 0;
        for (int i = 0, j = 0; i < len1 && j < len2 ;){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                //未保证初始化为0时候的去重
              /*  //去重
                if(isRepeated(res,nums1[i])){
                    i++;
                    j++;
                }else{
                    res[index++] = nums1[i];
                    i++;
                    j++;
                }*/

               //正确的去重
               if(index == 0 || res[index - 1] != nums1[i]){
                   res[index++] = nums1[i];
               }
               i++;
               j++;
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }

    public static boolean isRepeated(int[] res,int num){
        for (int i : res) {
            if(i == num){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //报错原因，res初始化的时候默认为0，所以0重复了，不会放入结果中
        int[] nums1 = {8,0,3};
        int[] nums2 = {1,1};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }

}
