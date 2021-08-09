package listNode;

import java.util.Stack;

public class AddTwoNumbers2 {

    public static void main(String[] args) {
        ListNode l1 = ListNode.createListNode(new int[]{7, 2, 4, 3});
        ListNode l2 = ListNode.createListNode(new int[]{5, 6, 4});
        System.out.println(addTwoNumbers(l1,l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2 = l2;
        Stack<Integer> stack1 = buildStack(cur1);
        Stack<Integer> stack2 = buildStack(cur2);
        int carry = 0;
        ListNode resNode = new ListNode(-1);
        ListNode tempNode = resNode;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int val1 = stack1.isEmpty() ? 0 : stack1.pop();
            int val2 = stack2.isEmpty() ? 0 : stack2.pop();
            tempNode.next = new ListNode((val1 + val2 + carry) % 10);
            carry = val1 + val2 + carry > 9 ? 1 : 0;
            tempNode = tempNode.next;
        }
        if (carry != 0) {
            tempNode.next = new ListNode(1);
        }
        return reversListNode(resNode.next);
    }

    public static Stack<Integer> buildStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        return stack;
    }

    public static ListNode reversListNode(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
