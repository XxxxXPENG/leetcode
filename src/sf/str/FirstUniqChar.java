package sf.str;

import java.util.ArrayList;
import java.util.List;

public class FirstUniqChar {
    /**
     * s = "abaccdeff"
     * 返回 "b"
     *
     * s = ""
     * 返回 " "
     */
    public char firstUniqChar(String s) {
        if(s == null || s.length() == 0) return ' ';
        List<Character> re = new ArrayList<>();
        for(int i = 0; i < s.length();i++){
            if(re.contains(s.charAt(i)))
                continue;
            if(s.indexOf(s.charAt(i),i+1) == -1)
                return s.charAt(i);
            re.add(s.charAt(i));

        }
        return ' ';
    }
}
