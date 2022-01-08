package union.re;

import java.util.*;

public class CanFinish {

    public static void main(String[] args) {
        int[][] arr = {
                {0, 1}
        };
        CanFinish c = new CanFinish();
        System.out.println(c.canFinish(2, arr));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        int n = prerequisites.length;
        if (n == 0) {
            return true;
        }

        int[] inDegree = new int[numCourses];
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new HashSet<>());
        }
        for (int[] pc : prerequisites) {
            inDegree[pc[0]]++;
            list.get(pc[1]).add(pc[0]);
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            count++;
            for (Integer i : list.get(poll)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
        return count == numCourses;
    }
}
