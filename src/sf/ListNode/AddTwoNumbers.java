package sf.ListNode;

import java.util.Stack;

/**
 * 示例:
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1),cur = res;
        Stack<Integer> stack1 = buildStack(l1);
        Stack<Integer> stack2 = buildStack(l2);
        int flow = 0;
        while (!stack1.empty() || !stack2.empty() || flow != 0 ){
            int x = stack1.isEmpty() ? 0 : stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = x + y + flow;
            flow = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            temp.next = cur.next;
            cur.next = temp;
        }
        return res.next;
    }
    public static Stack<Integer> buildStack(ListNode head){
        Stack<Integer> stack = new Stack();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        return stack;
    }
}
