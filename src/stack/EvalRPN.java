package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class EvalRPN {

    public static void main(String[] args) {
//        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
//        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(evalRPN(new String[]{"3","11","+","5","-"}));
    }

    public static int evalRPN2(String[] tokens) {

        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();

    }



    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        boolean isFirst = true;
        int res = 0;
        if(tokens != null && tokens.length == 1){
            return Integer.parseInt(tokens[0]);
        }
        for (String str : tokens) {
            if (!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")) {
                stack.push(Integer.parseInt(str));
            } else if (isFirst) {
                int a = stack.pop();
                int b = stack.pop();
                res = operation(str, b, a);
                isFirst = false;
            } else {
                int a = stack.pop();
                res = operation(str,a, res);
            }
        }
        return res;
    }

    public static int operation(String operation, int a, int b) {
        int res;
        switch (operation) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = b * a;
                break;
            default:
                res = a/b;
                break;
        }
        return res;
    }

}
