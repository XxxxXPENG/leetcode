package sf.arr.arr.doubleArr;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class DoubleArr_Find {
    public static boolean find(int[][] arr,int num){
        if(arr == null || arr.length == 0 || arr[0].length == 0){
            return false;
        }
        int i = arr.length , j = 0;//右上角开始
        //什么时候结束循环？ 当超出界限时
        while(i >= 0 && j <= arr[0].length){
            if(num == arr[i][j]){
                return true;
            }else if(num > arr[i][j]){
                j++;
            }else{
                i--;
            }
        }
        return false;
    }
}
