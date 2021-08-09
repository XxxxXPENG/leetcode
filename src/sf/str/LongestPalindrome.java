package sf.str;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    /**
     * 输入:
     * "abccccdd"
     *
     * 输出:
     * 7   dccaccd
     */
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
    public static int longestPalindrome(String s) {
        int res = 0;
        if(s == null || s.length() == 0){
            return res;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++ ){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }
        int len = 0,count = 0;
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() % 2 == 0){
                len += entry.getValue();
            }else if(entry.getValue() > 2){//大于2的基数
                len += entry.getValue() - 1;
                count++;
            }
        }
        len = count % 2 == 0 ? len + count : len + count - 1;
        return len == s.length() ? len : len+1;
    }

    public int longestPalindrome2(String s) {
        int[] arr = new int[128];
        for (char c : s.toCharArray()){
            arr[c]++;
        }
        int ans = 0;
        for (int v : arr){
            ans += v / 2 * 2;
            if(v % 2 == 1 && ans % 2 == 0){
                ans++;
            }
        }
        return ans;
    }
}
