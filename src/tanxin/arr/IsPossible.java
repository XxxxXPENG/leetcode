package tanxin.arr;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class IsPossible {

    public static void main(String[] args) {
        System.out.println(isPossible2(new int[]{1, 2, 3, 3, 4, 5}));
        System.out.println(isPossible2(new int[]{1, 2, 3, 4, 4, 5}));
    }


    //为什么赋值的时候为长度？
    public static boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, new PriorityQueue<>());
            }
            if (map.containsKey(num - 1)) {
                int preLength = map.get(num - 1).poll();
                if (map.get(num - 1).isEmpty()) {
                    map.remove(num - 1);
                }
                map.get(num).offer(preLength + 1);
            } else {
                map.get(num).offer(1);
            }
        }

        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;

    }

    public static boolean isPossible2(int[] nums) {
        Map<Integer, Integer> nc = new HashMap<>();
        Map<Integer, Integer> tail = new HashMap<>();
        for (int num : nums) {
            nc.put(num, nc.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            int count = nc.getOrDefault(num, 0);
            if (count > 0) {
                int pre = tail.getOrDefault(num - 1, 0);
                if (pre > 0) {
                    nc.put(num, count - 1);
                    tail.put(num - 1, pre - 1);
                    tail.put(num, tail.getOrDefault(num, 0) + 1);
                } else {
                    int count1 = nc.getOrDefault(num + 1, 0);
                    int count2 = nc.getOrDefault(num + 2, 0);
                    if (count1 > 0 && count2 > 0) {
                        nc.put(num, count - 1);
                        nc.put(num + 1, count1 - 1);
                        nc.put(num + 2, count2 - 1);
                        tail.put(num + 2, tail.getOrDefault(num + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
