package sf.arr;

public class RE_island {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };
        System.out.println(maxAreaOfIsland(arr));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) {
                    change(grid,i,j,grid.length,grid[0].length);
                    count++;
                }
            }
        }

        return count;
    }

    //老是越界？ 从执行前if() --> 开头if
    //arr[i][j] == 1 时 改变周围土地
    public static void change(int[][] arr,int i,int j,int len1,int len2){
        if(i < 0 || i >= len1 || j < 0 || j >= len2 || arr[i][j] != 1){
            return;
        }
        arr[i][j] = 2;
        change(arr,i-1,j,len1,len2); //左
        change(arr,i+1,j,len1,len2);//右
        change(arr,i,j-1,len1,len2);//上
        change(arr,i,j+1,len1,len2);//下
    }
}
