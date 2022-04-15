package hot100;

public class L136_只出现一次的数字 {
    //相同为0，不同为1
    //和自身亦或为0 ， 0和其他数亦或等于其他数
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
