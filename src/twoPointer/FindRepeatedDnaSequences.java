package twoPointer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindRepeatedDnaSequences {

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), output = new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len - 10 + 1; i++) {
            String temp = s.substring(i, i + 10);
            if (seen.contains(temp)) {
                output.add(temp);
            }
            seen.add(temp);
        }
        return new ArrayList<>(output);
    }
}
