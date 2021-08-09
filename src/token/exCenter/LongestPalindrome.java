package token.exCenter;

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }




        /*public static String longestPalindrome(String s) {
            if (s == null || s.length() < 1){
                return "";
            }

            // 初始化最大回文子串的起点和终点
            int start = 0;
            int end   = 0;

            // 遍历每个位置，当做中心位
            for (int i = 0; i < s.length(); i++) {
                // 分别拿到奇数偶数的回文子串长度
                int len_odd = expandCenter(s,i,i);
                int len_even = expandCenter(s,i,i + 1);
                // 对比最大的长度
                int len = Math.max(len_odd,len_even);
                // 计算对应最大回文子串的起点和终点
                if (len > end - start){
                    start = i - (len - 1)/2;
                    end = i + len/2;
                }
            }
            // 注意：这里的end+1是因为 java自带的左闭右开的原因
            return s.substring(start,end + 1);
        }


        *//**
         *
         * @param s             输入的字符串
         * @param left          起始的左边界
         * @param right         起始的右边界
         * @return              回文串的长度
         *//*
        private static int expandCenter(String s,int left,int right){
            // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
            // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
            // 跳出循环的时候恰好满足 s.charAt(left) ！= s.charAt(right)
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            // 回文串的长度是right-left+1-2 = right - left - 1
            return right - left - 1;
        }*/




    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        String maxStr = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j >= i; j--) {
                if (j - i + 1 < maxStr.length()) {
                    continue;
                }
                String temp = s.substring(i, j);
                if (isPalindrome(temp)) {
                    maxStr = temp.length() > maxStr.length() ? temp : maxStr;
                }
            }
        }
        return maxStr;
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
