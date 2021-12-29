package tu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinMutation {
    public int minMutation(String start, String end, String[] bank) {
        List<String> bankList= Arrays.asList(bank);
        Set<String> bankSet = new HashSet<>(bankList);
        if (bankList.isEmpty() || !bankSet.contains(end)) {
            return -1;
        }
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(start);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(end);
        Set<String> visited = new HashSet<>();
        int res = 0;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }
            Set<String> nextLevel = new HashSet<>();
            for (String str : beginVisited) {
                if (bfs(str, visited, bankSet,endVisited, nextLevel)) {
                    return res+1;
                }
            }
            beginVisited = nextLevel;
            res++;
        }
        return 0;
    }


    private boolean bfs(String str, Set<String> visited, Set<String> bankSet, Set<String> endVisited, Set<String> nextLevel) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            char originChar = arr[i];
            for (char j = 'A'; j <= 'Z'; j++) {
                if (j == originChar) {
                    continue;
                }
                arr[i] = j;
                String newStr = new String(arr);
                if (bankSet.contains(newStr)) {
                    if (endVisited.contains(newStr)) {
                        return true;
                    }
                    if (!visited.contains(newStr)) {
                        visited.add(newStr);
                        nextLevel.add(newStr);
                    }
                }
            }
            arr[i]=originChar;
        }
        return false;
    }
}
