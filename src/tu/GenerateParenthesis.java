package tu;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis t = new GenerateParenthesis();
        System.out.println(t.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs("", n, n, res);
        return res;
    }

    private void dfs(String str, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        //右括号数量大于左括号，剪枝
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(str + "(", left-1, right, res);
        }
        if (right > 0) {
            dfs(str + ")", left, right-1, res);
        }
    }

}
