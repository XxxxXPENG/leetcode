package Test;

public class ForTest {

    public static int for1(int len) {
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                count++;
            }
        }
        return count;
    }

    public static int for2(int len) {
        int count = 0;
        int i = 0;
        for (int j = 0;  i < len; j++) {
            count++;
            if (j == len - 1) {
                i++;
                j = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(for1(9));
        System.out.println(for2(9));
    }
}
