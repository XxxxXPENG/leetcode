package Test;

public class IntegerTest {
    /**
     * Integer在-128 - 127时，取值都为cache常量池中的数据
     * @param args
     */
    public static void main(String[] args) {
        Integer i1 = 1222;
        Integer i2 = 1222;
        System.out.println(i1 == i2);
    }
}
