package week.wk1;

/**
 * 进行+1 ， * 2 操作，* 2 有次数限制 ，最快次数得到target
 */

public class L5194_得到目标值的最少行动次数 {

    public static void main(String[] args) {
        L5194_得到目标值的最少行动次数 a = new L5194_得到目标值的最少行动次数();
        System.out.println(a.minMoves(10, 4));
    }

    public int minMoves(int target, int maxDoubles) {
        boolean a = false;
        target = a? target-- : --target; //why?
        int res = 0;
        while (1 != target) {
            if (maxDoubles > 0 && target % 2 == 0) {
                target = target / 2;
                res++;
                maxDoubles--;
            } else {
                if (maxDoubles == 0) {
                    res += target-1;
                    return res;
                }
                target--;
                res++;
            }
        }
        return res;
    }
}
