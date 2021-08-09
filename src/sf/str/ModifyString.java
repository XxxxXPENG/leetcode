package sf.str;

public class ModifyString {

    public static void main(String[] args) {

    }

    /**
     * 将字符串S中的?替换，使其不能连续
     * @param s
     * @return
     */
    public String modifyString(String s) {

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
           if(chars[i] == '?'){
               char pre = i == 0 ? ' ' : chars[i];
               char next = i == chars.length - 1 ? ' ' : chars[i];
               char temp = 'a';
               while (temp == pre || temp == next) {
                   temp++;
               }
               chars[i] = temp;
           }

        }
        return new String(chars);
    }

//    private char getChar(String s){
//        List<Character> list = new ArrayList<>();
//        for (int i = 'a'; i <= 'z' ; i++) {
//            list.add((char) i);
//        }
//        while(s.indexOf('?') != -1){
//            char pre,next;
//            int index = s.indexOf('?');
//            if(index - 1 >= 0 ){
//                pre = s.charAt(index - 1 );
//            }else if(index + 1 <= s.length() - 1){
//                next = s.charAt(index + 1);
//            }
//            //替换S中的?,为除了pre和next的元素
//            s = list.get()
//        }


}
