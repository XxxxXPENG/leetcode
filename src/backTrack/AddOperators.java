package backTrack;

import java.util.ArrayList;
import java.util.List;

public class AddOperators {
    public static void main(String[] args) {
        AddOperators a = new AddOperators();
        System.out.println(a.addOperators("105",5));
    }

    int n;
    String num;
    int target;
    List<String> ans;

    public List<String> addOperators(String num, int target) {
        this.n = num.length();
        this.target = target;
        this.num = num;
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(sb,0,0,0);
        return ans;
    }

    private void dfs(StringBuilder sb, int index, long res,long pre) {
        if (index == n) {
            if (res == target) {
                ans.add(sb.toString());
            }
            return;
        }
        long val = 0;
        int signIndex = sb.length();
        if (index > 0) {
            sb.append(0);
        }
        //不允许前导0
        for (int i = index; i < n && ( i == index || num.charAt(index) != '0'); ++i) {
            val = val * 10 + num.charAt(i) - '0';
            sb.append(num.charAt(i));
            if (index == 0) {
                dfs(sb, i + 1, val, val);
            } else {
                sb.setCharAt(signIndex, '+');
                dfs(sb, i + 1, res + val, val);
                sb.setCharAt(signIndex, '-');
                dfs(sb, i + 1, res - val, -val);
                sb.setCharAt(signIndex, '*');
                dfs(sb, i + 1, res - pre + pre * val, pre * val);
            }
        }
        sb.setLength(signIndex);

    }
}
