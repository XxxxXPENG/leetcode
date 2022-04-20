package hot100;


import java.util.HashMap;

/**
 * LC_146
 */
public class LRUCache {
    class DLinkedNode {
        int key;
        int val;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private int size;
    private DLinkedNode head, tail;
    private HashMap<Integer, DLinkedNode> cacheMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cacheMap.get(key);
        if (node == null) {
            return -1;
        }
        //存在则放置头部
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLinkedNode node = cacheMap.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cacheMap.put(key, newNode);
            addToHead(newNode);
            if (++size > capacity) {
                removeTail();
                --size;
            }
        } else {
            //存在，则修改值
            node.val = value;
            moveToHead(node);
        }
    }

    private void removeTail() {
        DLinkedNode res = tail.pre;
        removeNode(res);
        // 删除哈希表中对应的项
        cacheMap.remove(res.key);
    }

    //将node放置头部，其他向后移动
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


}
