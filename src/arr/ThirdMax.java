package arr;

import java.util.*;

public class ThirdMax {

    public static void main(String[] args) {

        System.out.println(thirdMax(new int[]{2,3,1,2}));
    }

    public static int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o));

        //todo 需要去重 ？
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        set.forEach(pq::offer);

        int index = 0, res = Integer.MIN_VALUE,max = Integer.MIN_VALUE;
        while (!pq.isEmpty() && index < 3) {
            if (index == 0) {
                max = pq.poll();
            }else{
                res = pq.poll();
            }
            index++;
        }
        return index < 3 ? max : res;
    }

    public static int thirdMax1(int[] nums) {
        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (res.contains(num)) {
                continue;
            }
            res.add(num);
        }

        int len = res.size();
        if (len == 1 || len == 2) {
            return res.get(len - 1);
        }
        return res.get(len - 3);
    }
}
