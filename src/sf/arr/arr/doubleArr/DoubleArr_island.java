package sf.arr.arr.doubleArr;

public class DoubleArr_island {
    /**
     * 1 为土地，相邻的1为一个小岛。
     * 问有多少个小岛
     * @param arr
     * @return
     */
    public static int count(int[][] arr){
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1){
                    infect(arr,i,j,arr.length,arr[0].length);//这个岛有多大
                    res++;
                }
            }
        }
        return res ;
    }

    public static void infect(int[][] arr, int i, int j, int length, int length2) {
        if(i >= length || i < 0 || j>=length2 || j < 0 || arr[i][j] != 1)
            return;
        arr[i][j] = 2;
        infect(arr, i+1, j, length, length2);
        infect(arr, i-1, j, length, length2);
        infect(arr, i, j+1, length, length2);
        infect(arr, i, j-1, length, length2);
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0,1,0,1},
                {1,0,0,1},
                {1,0,0,0}};
        System.out.println(count(arr));
    }
}
