package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
       String s = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        System.out.println(wordPattern("abba", "dog cat cat dog"));

        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        Map map = new HashMap<>();
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        for (Integer i = 0; i < pattern.length(); i++) {
            if (map.put(pattern.charAt(i), i) != map.put(arr[i], i)) {
                return false;
            }
        }
        return false;
    }

    public static boolean wordPattern2(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }
        HashMap<Object, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if(!Objects.equals(hashMap.put(pattern.charAt(i), i), hashMap.put(strings[i], i))){
                return false;
            }
        }
        return true;
    }
}
