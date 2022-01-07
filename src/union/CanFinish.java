package union;

import java.util.*;

public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }

        int len = prerequisites.length;
        if (len == 0) {
            return true;
        }
        int[] inDegree = new int[numCourses];
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }
        for (int[] pc : prerequisites) {
            inDegree[pc[0]]++;
            adj[pc[1]].add(pc[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count=0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            count++;
            for (Integer i : adj[poll]) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
        return count == numCourses;
    }


}
