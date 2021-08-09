package sf.str;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf")); // dabdc
    }

    public static int lengthOfLongestSubstring(String s) {
        String res = "";
        int size = 0,temp = 0;
        for(int i = 0; i < s.length(); i++){
            if(res.indexOf(s.charAt(i)) == -1){
                res +=s.charAt(i);
            }else{//如果重复了，让 之前的字符从后往前找如果于现在这个字符不同则保留 (这个字符重新开始
                String tempRes = res;
                res = s.charAt(i) + "";
                for (int j = tempRes.length() - 1; tempRes.charAt(j) != s.charAt(i); j-- ){
                    res = tempRes.charAt(j) + res ;
                }
            }
            temp = res.length();
            size = Math.max(temp,size);
        }
        return size;
    }
}
