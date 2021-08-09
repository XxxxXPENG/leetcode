package sf.str;

/**
 * 将一个字符串中的空格替换成 "%20"。
 *
 * Input:
 * "A B"
 *
 * Output:
 * "A%20B"
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String str = "A B";
        System.out.println(replaceSpace2(str));
    }


    //双指针做法

    /**
     * 思路：
     * 碰到一个空格 就在末尾添加2个空格；
     * 用双指针，从后向前重新构造str
     */
    public static String replaceSpace2(String str){
        StringBuffer sb = new StringBuffer(str);
        int p1 = sb.length()-1;
        for(int i = 0; i< str.length(); i++){
            if(str.charAt(i) == ' '){
                sb.append("  ");
            }
        }
        int p2 =  sb.length()-1;
        //从后往前遍历 重新填充sb
       while(p1 >= 0 && p2 >= p1){
            char c = sb.charAt(p1--);
            if(c == ' '){
                sb.setCharAt(p2--,'0');
                sb.setCharAt(p2--,'2');
                sb.setCharAt(p2--,'%');
            }else{
                sb.setCharAt(p2--, c);
            }
        }
       return sb.toString();
    }


    //错误尝试
    public static String replaceSpace(String str){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i)==' '){
                sb.append("%20");
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
