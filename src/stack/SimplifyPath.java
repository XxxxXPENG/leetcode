package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
//        System.out.println(simplifyPath("/a/./b/../../c/"));
//        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath2("/home//foo/"));

    }

    public static String simplifyPath(String path) {
        StringBuilder res = new StringBuilder("/");
        Stack<String> stack = new Stack<>();
        for (String str : path.split("/")) {
            //这里变为2个if, 是因为 一个是存在栈为空，pop时异常问题；
            //如果刚开始就碰到..的话，就不处理。
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }else if (!str.isEmpty() && !str.equals(".")) {
                stack.push(str);
            }
        }
        while (!stack.isEmpty()) {
            res.insert(1, stack.pop() + "/");
        }
        if (res.length() == 1) {
            return "/";
        }
        return res.toString().substring(0,res.length()-1);
    }

    public static String simplifyPath2(String path) {
        String res = "";
        Deque<String> stack = new LinkedList<>();
        for (String str : path.split("/")) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!str.isEmpty() && !str.equals(".")) {
                stack.push(str);
            }
        }
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res.isEmpty() ? "/" : res;
    }

    }
