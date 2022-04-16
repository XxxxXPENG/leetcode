package hot100;

import java.util.List;

public class L139_单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0]=true;
        for (int i = 0; i < len; i++) {

            for (String word : wordDict) {
                if (!dp[i]) {
                    continue;
                }

                if (i + word.length() <= len && s.startsWith(word, i)) {
                    dp[i+word.length()] = true;
                }
            }
        }
        return dp[len];
    }
}
