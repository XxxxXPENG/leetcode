package token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort {
    public static String frequencySort(String s) {
        Map<Character,Integer> countMap = new HashMap<>();
        for(char c : s.toCharArray()){
            countMap.put(c,countMap.getOrDefault(c,0)+1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(countMap.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        StringBuilder res = new StringBuilder();
        for (Map.Entry<Character, Integer> map : list) {
            for (int i = 0; i < map.getValue(); i++) {
                res.append(map.getKey());
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));;
    }
}
