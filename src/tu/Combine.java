package tu;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    public static void main(String[] args) {
        Combine c = new Combine();
        System.out.println(c.combine(4,2));
    }


    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return res;
    }

    private void dfs(int i, int n, int k) {
        if (list.size() + n - i + 1 < k) {
            return;
        }
        if (list.size() == k) {
            //引用问题，需要重新new
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(i);
        dfs(i + 1, n, k);
        list.remove(list.size() - 1);
        dfs(i + 1, n, k);
    }
}
