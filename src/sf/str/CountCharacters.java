package sf.str;

public class CountCharacters {
    /**
     * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
     * 输出：6
     * 解释：
     * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
     *
     */
    public static void main(String[] args) {
        String[] arr ={"cat","bt","hat","tree"};
        System.out.println(countCharacters2(arr,"atach"));
    }
    public static int countCharacters2(String[] words, String chars) {
        int[] chars_count = count(chars);
        int res = 0;
        for(String word : words){
            int[] word_count = count(word);
            if(contains(chars_count,word_count)){
                res += word.length();
            }
        }
        return res;
    }

    private static boolean contains(int[] chars_count,int[] word_count) {
        for (int i =0; i < 26; i++){
            if(chars_count[i] < word_count[i]){
                return false;
            }
        }
        return true;

    }

    public static int[] count(String word){
        int[] counter = new int[26];
        for (int i = 0; i < word.length();i++){
            char c = word.charAt(i);
            counter[c-'a']++;
        }
        return counter;
    }

    public static int countCharacters(String[] words, String chars) {
        int count = 0;
        boolean[] visited = new boolean[chars.length()];
        for (int i = 0; i < words.length; i++ ){
            for(int j = 0,k = 0; j < words[i].length();){
                if(k == chars.length()) break;
                if(words[i].charAt(j) != chars.charAt(k) || visited[k]){
                    k++;
                }else{ //找到了
                    visited[k] = true;
                    k = 0;
                    j++;
                }
                if(j == words[i].length()){
                    count += words[i].length();
                    visited = new boolean[chars.length()];
                }
            }
        }
        return count;
    }
}
