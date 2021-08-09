package tanxin;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,0,1},2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int preIndex = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                preIndex = i;
            } else if (i - preIndex > 1 && i + 1 < flowerbed.length && flowerbed[i+1] != 1) {
                n--;
                preIndex = i;
            }
        }
        return n <= 0;
    }

    public static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        for (int i = 0, len = flowerbed.length; i < flowerbed.length && n > 0; ) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == len - 1 || flowerbed[i + 1] == 0) {
                n--;
                i += 2;
            } else {
                n +=3;
            }
        }
        return n <= 0;
    }
}
