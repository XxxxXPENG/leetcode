package tree.level;

import java.util.*;

/**
 * 层次遍历，员工重要性
 */
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class GetImportance {
    public int getImportance(List<Employee> employees, int id) {
        int res = 0;
        Map<Integer, Employee> map = new HashMap<>();
        employees.forEach(employee -> map.put(employee.id, employee));
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(id);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int subId = queue.poll();
                Employee e = map.get(subId);
                res += e.importance;
                queue.addAll(e.subordinates);
            }
        }
        return res;
    }
}
