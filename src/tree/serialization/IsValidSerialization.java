package tree.serialization;

public class IsValidSerialization {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        String[] split = preorder.split(",");
        int count = 1;
        for (String s : split) {
            if (count == 0) {
                return false;
            }
            if (s.equals("#")) {
                count--;
            } else {
                count++;
            }
        }
        return count==0;
    }
}
