package map;

import java.util.*;

public class WordPattern2 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic2("paper","title"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (char c : s.toCharArray()) {
            set1.add(c);
        }
        for (char c : t.toCharArray()) {
            set2.add(c);
        }
        if (set1.size() != set2.size()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                continue;
            }
            map.put(s.charAt(i), t.charAt(i));
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return Objects.equals(new String(arr), t);
    }


    public static boolean isIsomorphic2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        //todo paper title  false问题   应该为true
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.put(s.charAt(i), i) != map.put(t.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }

    
}
