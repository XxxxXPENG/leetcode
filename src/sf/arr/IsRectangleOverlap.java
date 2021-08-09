package sf.arr;

public class IsRectangleOverlap {
    /**
     * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
     * 输出：true
     */
    public static void main(String[] args) {
        int[] arr = {0, 0, 2, 2};
        int[] arr2 = {1, 1, 3, 3};
        System.out.println(isRectangleOverlap(arr, arr2));
    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0], y1 = rec1[1], x2 = rec1[2], y2 = rec1[3];
        int x3 = rec2[0], y3 = rec2[1], x4 = rec2[2], y4 = rec2[3];
        boolean flag = false;
        if ((x1 > x3 && x1 < x4) || (x2 > x3 && x2 < x4)) {
            if ((y1 > y3 && y1 < y4) || (y2 > y3 && y2 < y4))
                flag = true;
        }
        return flag;
    }

    public static boolean isRectangleOverlap2(int[] rec1, int[] rec2) {
        int x1 = Math.max(rec1[0], rec2[0]);
        int x2 = Math.min(rec1[2], rec2[2]);
        int y1 = Math.max(rec1[1], rec2[1]);
        int y2 = Math.min(rec1[3], rec2[3]);
        return x1 < x2 && y1 < y2 ? true : false;
    }
}
