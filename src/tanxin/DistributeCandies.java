package tanxin;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int num : candyType) {
            set.add(num);
        }
        return Math.min(candyType.length / 2, set.size());
    }
}
