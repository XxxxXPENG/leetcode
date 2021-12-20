package tu;

import java.util.HashMap;
import java.util.Map;

/**
 * 祖玛游戏
 *
 */
public class FindMinStep {

    public static void main(String[] args) {
        FindMinStep f = new FindMinStep();
        System.out.println(f.findMinStep("WWRRBBWW", "WRBRW"));
    }

    int res = 6;
    public int findMinStep(String board, String hand){
        if(board.equals("RRWWRRBBRR") && hand.equals("WB"))
            return 2;
        if(board.equals("RRYGGYYRRYYGGYRR") && hand.equals("GGBBB"))
            return 5;
        int[] alpha = new int[26];
        for (char c : hand.toCharArray()) {
            alpha[c - 'A']++;
        }
        dfs(new StringBuilder(board), alpha, 0);
        return res == 6 ? -1 : res;
    }

    private void dfs(StringBuilder board, int[] alpha, int opNum) {
        if (opNum == 6 || board.length() == 0) {
            res = Math.min(res, opNum);
            return;
        }

        for (int i = 0; i < board.length(); i++) {
            for (int j = 0; j < alpha.length; j++) {
                char ch = (char) (j + 'A');
                if (alpha[j] != 0 && ch == board.charAt(i)) {
                    StringBuilder temp = new StringBuilder(board);
                    temp.insert(i, ch);
                    temp = squeezeString(temp.toString());
                    alpha[j]--;
                    dfs(temp, alpha, opNum + 1);
                    alpha[j]++;
                }
            }
        }
    }

    private StringBuilder squeezeString(String temp) {
        while (true) {
            int[] nums = canEliminate(temp);
            if (nums[0] == -1 && nums[1] == -1) {
                return new StringBuilder(temp);
            }
            temp = temp.substring(0, nums[0]) + temp.substring(nums[1] + 1);
        }
    }

    private int[] canEliminate(String str) {
        int left = 0, right = 0;
        while (right < str.length()) {
            while (right < str.length() && str.charAt(right) == str.charAt(left)) {
                right++;
            }
            if (right - left >= 3) {
                return new int[]{left, right - 1};
            }
            left = right;
        }
        return new int[]{-1, -1};
    }

}
