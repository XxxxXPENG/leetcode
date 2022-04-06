package hot100.re4;

import java.util.*;

public class L49_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String k = new String(chars);
            List<String> list = map.getOrDefault(k, new ArrayList<>());
            list.add(str);
            map.put(k,list);
        }
        return new ArrayList<>(map.values());
    }
}
