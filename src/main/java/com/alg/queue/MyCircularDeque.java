package main.java.com.alg.queue;

/**
 * 设计实现双端队列。
 * <p>
 * 实现 MyCircularDeque 类:
 * <p>
 * MyCircularDeque(int k)：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true，否则返回 false 。
 * boolean insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true，否则返回 false 。
 * boolean deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true，否则返回 false 。
 * boolean deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true，否则返回 false 。
 * int getFront())：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * int getRear()：获得双端队列的最后一个元素。如果双端队列为空，返回 -1 。
 * boolean isEmpty()：若双端队列为空，则返回true，否则返回 false 。
 * boolean isFull()：若双端队列满了，则返回true，否则返回 false 。
 * <p>
 * ----------------------------------------- 举例 ------------------------------------------
 * 输入
 * ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 * 输出
 * [null, true, true, true, false, 2, true, true, true, 4]
 * <p>
 * 解释
 * MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			    // 返回 true
 * circularDeque.insertFront(4);			    // 已经满了，返回 false
 * circularDeque.getRear();  				    // 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			    // 返回 true
 * circularDeque.getFront();				    // 返回 4
 * <p>
 * ----------------------------------------- 提示 ------------------------------------------
 * 1 <= k <= 1000
 * 0 <= value <= 1000
 * insertFront,insertLast,deleteFront,deleteLast,getFront,getRear,isEmpty,isFull 调用次数不大于2000次
 */

public class MyCircularDeque {

    private final int max;
    private int length;
    private Node<Integer> first;
    private Node<Integer> last;

    public MyCircularDeque(int k) {
        length = 0;
        max = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            var node = new Node<>(null, value, null);
            first = node;
            last = node;
        } else {
            var node = new Node<>(null, value, first);
            first.prev = node;
            first = node;
        }

        length++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            var node = new Node<>(null, value, null);
            first = node;
            last = node;
        } else {
            var node = new Node<>(last, value, null);
            last.next = node;
            last = node;
        }

        length++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }

        length--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        last = last.prev;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }

        length--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : first.item;
    }

    public int getRear() {
        return isEmpty() ? -1 : last.item;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == max;
    }

    private class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}