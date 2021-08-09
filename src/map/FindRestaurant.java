package map;

import java.util.*;

public class FindRestaurant {

    public static void main(String[] args) {
        String[] arr1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] arr2 = {"KFC","Burger King","Tapioca Express","Shogun"};
        System.out.println(Arrays.toString(findRestaurant(arr1,arr2)));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            map.put(list2[i], i);
        }
        int minIndex = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list1.length && i <= minIndex; i++) {
            String str = list1[i];
            if (map.containsKey(str) && (i + map.get(str)) < minIndex) {
                res.clear();
                res.add(str);
                minIndex = i + map.get(str);
            } else if (map.containsKey(str) && (i + map.get(str)) == minIndex) {
                res.add(str);
            }
        }

        return res.toArray(new String[res.size()]);
    }
}