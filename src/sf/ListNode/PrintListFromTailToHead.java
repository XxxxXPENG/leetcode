package sf.ListNode;

import java.util.ArrayList;

public class PrintListFromTailToHead {
    //返回链表类
    //双指针（其实就是头插法）
    public ListNode PrintListFromTailToHead(ListNode head){
        ListNode dummy = new ListNode(-1);
        /**
         * A -> B  -> C
         * B -> C  -> A   此时BC为head
         * C -> B -> A    此时head为C ，无子节点
         *
         * 就是将下一个节点插入头部。当头节点无子节点时结束
         */
        while(head != null){
            //1.创建临时节点
            ListNode temp = head.next;
            //2.将当前节点插入头部
            head.next = dummy.next;
            dummy.next = head;
            //3.更新为下一个待处理节点
            head = temp;
        }
        //返回新链表的头节点
        return dummy.next;
    }
    //递归 -------  做错了
    public ListNode PrintListFromTailToHead2(ListNode head){
        ListNode res = null;
        if(head != null && head.next != null){
            res = PrintListFromTailToHead2(head.next);
            head.next = res.next;
            res.next = head;
        }
        return res;
    }

    ArrayList<Integer> list =  new ArrayList();
    //方法1，递归调用，相当于用栈
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        while(listNode != null){
            printListFromTailToHead1(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    //头插法
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        while(listNode != null){
            list.add(0,listNode.val);
            listNode = listNode.next;
        }
//        int[] res = new int[list.size()];
//        for (int i = 0; i < list.size(); i++ ) {
//            res[i] = list.get(i);
//        }
        return list;
    }

    public ArrayList<Integer> REprintListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode != null){
            REprintListFromTailToHead(listNode.next);
            res.add(listNode.val);
        }
        return res;
    }
}
