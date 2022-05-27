package hot100;

public class L461_汉明距离 {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        return Integer.bitCount(num);
    }

    public int hammingDistance2(int x, int y) {
        int num = x ^ y;
        int res = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                res++;
            }
            num >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        L461_汉明距离 a = new L461_汉明距离();
        System.out.println(a.hammingDistance2(1,3));
    }
}
