package sf.binary;

public class NextGreatestLetter {
    public static void main(String[] args) {
        char[] arr = {'c','f','j'};
        System.out.println(nextGreatestLetter(arr,'j'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        while( l <= r){
            int mid =  l + (r - l)/2;
            if(letters[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        System.out.println(l % letters.length);
        return letters[l % letters.length];
    }
}
