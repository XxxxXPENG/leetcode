package week.wk5;

public class L6008_统计包含给定前缀的字符串 {
    public int prefixCount(String[] words, String pref) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int res = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                res++;
            }
        }
        return res;
    }
}
