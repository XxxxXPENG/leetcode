package backTrack;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {

    public List<Integer> diffWaysToCompute(String expression) {
        return divideAndConquer(expression.toCharArray());
    }

    private List<Integer> divideAndConquer(char[] expression) {
        List<Integer> res = new ArrayList<>();
        if (isOneNum(expression)) {
            int num = 0;
            for (int i = 0; i < expression.length; i++) {
                num = num * 10 + expression[i] - '0';
            }
            res.add(num);
            return res;
        }
        for (int i = 0; i < expression.length; i++) {
            if (!Character.isDigit(expression[i])) {
                char[] left = new char[i];
                char[] right = new char[expression.length - i - 1];
                System.arraycopy(expression, 0, left, 0, i);
                System.arraycopy(expression, i + 1, right, 0, expression.length - 1 - i);
                List<Integer> leftList = divideAndConquer(left);
                List<Integer> rightList = divideAndConquer(right);
                List<Integer> tempRes = calculate(leftList, rightList, expression[i]);
                res.addAll(tempRes);
            }
        }
        return res;
    }

    private List<Integer> calculate(List<Integer> listOne, List<Integer> listTwo, char operator) {
        List<Integer> res = new ArrayList<>();
        for (int i=0;i<listOne.size();i++){
            for (int j=0;j<listTwo.size();j++){
                res.add(calculateTwoNums(listOne.get(i),listTwo.get(j),operator));
            }
        }
        return res;

    }

    //简单的计算函数
    public static Integer calculateTwoNums(int num1,int num2,char operator){
        switch(operator) {
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            default:
                return num1*num2;
        }
    }


    private boolean isOneNum(char[] expression) {
        for (int i = 0; i < expression.length; i++) {
            if (!Character.isDigit(expression[i])) {
                return false;
            }
        }
        return true;
    }
}
