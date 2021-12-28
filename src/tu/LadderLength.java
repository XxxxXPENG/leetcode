package tu;

import java.util.*;

public class LadderLength {
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordList.isEmpty() || !wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);
        Set<String> visited = new HashSet<>();

        int res = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            //使用较短集合进行遍历
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }
            Set<String> nextLevelSet = new HashSet<>();
            for (String word : beginVisited) {
                if (dfs(word, endVisited, visited, wordSet, nextLevelSet)) {
                    return res + 1;
                }
            }

            beginVisited = nextLevelSet;
            res++;
        }
        return 0;
    }

    private boolean dfs(String word, Set<String> endVisited, Set<String> visited, Set<String> wordSet, Set<String> nextLevelSet) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char originChar = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (originChar == c) {
                    continue;
                }
                arr[i] = c;
                String nextWord = new String(arr);
                if (wordSet.contains(nextWord)) {
                    if (endVisited.contains(nextWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        visited.add(nextWord);
                        nextLevelSet.add(nextWord);
                    }
                }
            }
            arr[i] = originChar;
        }
        return false;
    }




    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordList.isEmpty() || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (dfs(poll, endWord, queue, visited, wordSet)) {
                    return res+1;
                }
            }
            res++;
        }
        return 0;
    }
    private boolean dfs(String poll, String endWord, Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] charArr = poll.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            char originChar = charArr[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (originChar == j) {
                    continue;
                }
                charArr[i] = j;
                String nextWord = new String(charArr);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        queue.offer(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            charArr[i] = originChar;
        }
        return false;
    }
}
