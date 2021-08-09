package map;

import java.util.*;

public class FindWords {

    public static void main(String[] args) {
        String[] arr = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(findWords(arr)));
    }

    public static String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list1 = Arrays.asList('Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P');
        List<Character> list2 = Arrays.asList('A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L');
        List<Character> list3 = Arrays.asList('Z', 'X', 'C', 'V', 'B', 'N', 'M');
        list1.forEach(c -> map.put(c, 1));
        list2.forEach(c -> map.put(c, 2));
        list3.forEach(c -> map.put(c, 3));
        List<String> resList = new ArrayList<>();
        for (String str : words) {
            int level = 0;
            boolean flag = true;
            for (int i = 0; i < str.length(); i++) {
                char c = Character.toUpperCase(str.charAt(i));
                if (level != 0 && level != map.get(c)) {
                    flag = false;
                    break;
                }
                level = map.get(c);
                if (i == str.length() - 1) {
                    flag = level == map.get(c);
                }
            }
            if (flag) {
                resList.add(str);
            }
        }
        System.out.println(resList);
        String[] res = new String[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
