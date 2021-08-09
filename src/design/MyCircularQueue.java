package design;

public class MyCircularQueue {
    private int[] queue;
    private int headIndex;
    private int count;
    private int capacity;

    public MyCircularQueue(int k) {
        queue = new int[k];
        capacity = k;
        headIndex = 0;
        count = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        //headIndex, capacity, count -> tailIndex
        int tailIndex = (headIndex + count - 1) % capacity;
        queue[tailIndex] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        headIndex = (headIndex + 1) % capacity;
        count--;
        return true;

    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[headIndex];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int tailIndex = (headIndex + count - 1) % capacity;
        return queue[tailIndex];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}
