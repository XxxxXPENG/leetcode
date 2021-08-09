package stack;

public class LengthLongestPath {
    public int lengthLongestPath(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        int res = 0;
        int[] sum = new int[input.length() - 1];
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 2;
            
        }
        return 0;
    }
}
