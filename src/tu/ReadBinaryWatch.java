package tu;

import java.util.ArrayList;
import java.util.List;


public class ReadBinaryWatch {

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(10));
    }

    /**
     * 计算二进制中1的个数
     *
     * @param turnedOn
     * @return
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    res.add(i + ":" + (j < 10 ? "0" : "") + j);
                }
            }
        }
        return res;
    }
}
