package sf.arr.arr.doubleArr;

public class DoubleArr_orangesRotting {
    /**
     * 在给定的网格中，每个单元格可以有以下三个值之一：
     *
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
     *
     *  输入：[  [2,1,1],
     *          [1,1,0],
     *          [0,1,1]]
     * 输出：4
     *
     *   思路：  类似病毒传播问题。
     */
    public static void main(String[] args) {
        int[][] arr = {{2,1,1},
                       {1,1,0},
                       {0,1,1}};
        System.out.println(orangesRotting(arr));
    }

    public static int orangesRotting(int[][] grid) {
        int count = 0 ,sum = 0;
        //腐烂计时
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2 && canSpread(grid,i,j,grid.length,grid[0].length)){
                    spread(grid,i,j,grid.length,grid[0].length);
                    count++;
                }
            }
        }
        //判断是否腐烂完
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    sum++;
            }
        }
        return sum > 0 ?  -1 : count;

    }
    public static boolean canSpread(int[][] arr,int i,int j,int len,int len2){
        boolean flag = false;
        if(i > 0 && arr[i-1][j] == 1 ) flag = true;
        if(i < len-1 && arr[i+1][j] == 1) flag = true;
        if(j > 0 && arr[i][j-1] == 1) flag = true;
        if(j < len2-1 && arr[i][j+1] == 1) flag = true;
        return flag;
    }
    //传播腐烂
    public static void spread(int[][] arr,int i,int j,int len,int len2){
       if(i > 0 && arr[i-1][j] == 1 ) arr[i-1][j] = 2;
       if(i < len-1 && arr[i+1][j] == 1) arr[i+1][j] = 2;
       if(j > 0 && arr[i][j-1] == 1) arr[i][j-1] = 2;
       if(j < len2-1 && arr[i][j+1] == 1) arr[i][j+1] = 2;
    }
}
