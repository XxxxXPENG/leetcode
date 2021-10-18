package twoPointer.stage;

import java.util.Arrays;

public class FindRadius {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0, i = 0;
        for (int house : houses) {
            //比之前距离更近才需要移动
            while (i < heaters.length - 1 && Math.abs(heaters[i] - house) >= Math.abs(heaters[i + 1] - house)) {
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }
        return res;
    }
}
