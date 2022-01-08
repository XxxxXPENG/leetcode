package union;

import java.util.*;

public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if (numCourses <= 0) {
            return res;
        }
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new HashSet<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] arr : prerequisites) {
            inDegree[arr[0]]++;
            list.get(arr[1]).add(arr[0]);
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                deque.add(i);
            }
        }
        int index = 0;
        while (!deque.isEmpty()) {
            Integer poll = deque.poll();
            res[index] = poll;
            index++;
            for (int nextCourse  : list.get(poll)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse ] == 0) {
                    deque.add(nextCourse );
                }
            }
        }
        if (index == numCourses) {
            return res;
        }
        return new int[0];
    }
}
