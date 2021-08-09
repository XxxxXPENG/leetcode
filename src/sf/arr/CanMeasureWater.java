package sf.arr;

import java.util.*;

public class CanMeasureWater {
    /**
     * 输入: x = 3, y = 5, z = 4
     * 输出: True
     */
    public static void main(String[] args) {
        System.out.println(canMeasureWater(0, 2, 1));
    }

    public static boolean canMeasureWater(int x, int y, int z) {
        if (z > (x + y) || z < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(y);
        list.add(x + y);
        list.add(y - x);
        list.add(2 * y - x);
        int minD = 2 * x - y;
        while (minD < 0) {
            minD += x;
        }
        list.add(minD + y);
        //大的装得下就放大的
        while (minD < y) {
            list.add(minD);
            minD += x;
        }
        return list.contains(z);
    }


    public boolean canMeasureWater2(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }
        Queue<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
        AbstractMap.SimpleEntry<Integer, Integer> start = new AbstractMap.SimpleEntry<>(0, 0);
        queue.add(start);
        Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            int curX = entry.getKey();
            int curY = entry.getValue();
            if (curX == z || curY == z || curX + curY == z) {
                return true;
            }
            if (curX == 0) {
                // 把第一个桶填满
                addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(x, curY));
            }
            if (curY == 0) {
                // 把第二个桶填满
                addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX, y));
            }
            if (curY < y) {
                // 把第一个桶倒空
                addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(0, curY));
            }
            if (curX < x) {
                // 把第二个桶倒空
                addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX, 0));
            }

            // y - curY是第二个桶还可以再加的水的升数，但是最多只能加curX升水。
            int moveSize = Math.min(curX, y - curY);
            // 把第一个桶里的curX升水倒到第二个桶里去。
            addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX - moveSize, curY + moveSize));
            // 反过来同理，x - curX是第一个桶还可以再加的升数，但是最多只能加curY升水。
            moveSize = Math.min(curY, x - curX);
            // 把第一个桶里的curX升水倒到第二个桶里去。
            addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX + moveSize, curY - moveSize));
        }
        return false;
    }

    private void addIntoQueue(Queue<Map.Entry<Integer, Integer>> queue,
                              Set<Map.Entry<Integer, Integer>> visited,
                              Map.Entry<Integer, Integer> newEntry) {
        if (!visited.contains(newEntry)) {
            visited.add(newEntry);
            queue.add(newEntry);
        }
    }


    public boolean canMeasureWater_BFS(int x, int y, int z) {
        if (z < 0 || z > x + y) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int n = q.poll();
            if (n + x <= x + y) {
                set.add(x + n);
                q.offer(x + n);
            }
            if (n + y <= x + y) {
                set.add(y + n);
                q.offer(y + n);
            }
            if (n - x >= 0) {
                set.add(y - x);
                q.offer(n - x);
            }
            if (n - y >= 0) {
                set.add(n - y);
                q.offer(n - y);
            }
            return set.contains(z);
        }
        return false;

    }
}