package dp;

import java.util.Arrays;
import java.util.List;

public class L139_单词拆分 {
    public static void main(String[] args) {
        L139_单词拆分 a = new L139_单词拆分();
        System.out.println(a.wordBreak2("applepenapple",Arrays.asList("apple","pen")));
    }



        //DP
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            if (!dp[i]) {
                continue;
            }
            for (String word : wordDict) {
                if (word.length() + i <= s.length() && s.startsWith(word,i)) {
                    dp[i+word.length()] = true;
                }
            }
        }
        return dp[len];
    }


    //DFS
    public boolean wordBreak2(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] visited = new boolean[len + 1];
        return dfs(s, 0, wordDict, visited);
    }

    private boolean dfs(String s, int start, List<String> wordDict, boolean[] visited) {
        for (String word : wordDict) {
            int nextStart = start + word.length();
            if (nextStart > s.length() || visited[nextStart]) {
                continue;
            }

            if (s.indexOf(word, start) == start) {
                if (nextStart == s.length() || dfs(s, nextStart, wordDict, visited)) {
                    return true;
                }
                visited[nextStart] = true;
            }
        }
        return false;
    }
}
