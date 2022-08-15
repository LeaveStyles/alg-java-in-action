import main.java.com.alg.queue.MyCircularDeque;

public class MyCircularDequeTest {
    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(77);

        String[] ops = new String[]{"insertFront", "getRear", "deleteLast", "getRear", "insertFront", "insertFront", "insertFront", "insertFront", "isFull", "insertFront", "isFull", "getRear", "deleteLast", "getFront", "getFront", "insertLast", "deleteFront", "getFront", "insertLast", "getRear", "insertLast", "getRear", "getFront", "getFront", "getFront", "getRear", "getRear", "insertFront", "getFront", "getFront", "getFront", "getFront", "deleteFront", "insertFront", "getFront", "deleteLast", "insertLast", "insertLast", "getRear", "getRear", "getRear", "isEmpty", "insertFront", "deleteLast", "getFront", "deleteLast", "getRear", "getFront", "isFull", "isFull", "deleteFront", "getFront", "deleteLast", "getRear", "insertFront", "getFront", "insertFront", "insertFront", "getRear", "isFull", "getFront", "getFront", "insertFront", "insertLast", "getRear", "getRear", "deleteLast", "insertFront", "getRear", "insertLast", "getFront", "getFront", "getFront", "getRear", "insertFront", "isEmpty", "getFront", "getFront", "insertFront", "deleteFront", "insertFront", "deleteLast", "getFront", "getRear", "getFront", "insertFront", "getFront", "deleteFront", "insertFront", "isEmpty", "getRear", "getRear", "getRear", "getRear", "deleteFront", "getRear", "isEmpty", "deleteFront", "insertFront", "insertLast", "deleteLast"};
        int[] values = new int[]{89, 0, 0, 0, 19, 23, 23, 82, 0, 45, 0, 0, 0, 0, 0, 74, 0, 0, 98, 0, 99, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 75, 0, 0, 35, 59, 0, 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 21, 0, 26, 63, 0, 0, 0, 0, 87, 76, 0, 0, 0, 26, 0, 67, 0, 0, 0, 0, 36, 0, 0, 0, 72, 0, 87, 0, 0, 0, 0, 85, 0, 0, 91, 0, 0, 0, 0, 0, 0, 0, 0, 0, 34, 44, 0};

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "insertFront" -> System.out.println("insertFront : " + deque.insertFront(values[i]));
                case "insertLast" -> System.out.println("insertLast : " + deque.insertLast(values[i]));
                case "getRear" -> System.out.println("getRear : " + deque.getRear());
                case "getFront" -> System.out.println("getFront : " + deque.getFront());
                case "deleteLast" -> System.out.println("deleteLast : " + deque.deleteLast());
                case "deleteFront" -> System.out.println("deleteFront : " + deque.deleteLast());
                case "isFull" -> System.out.println("isFull : " + deque.isFull());
                case "isEmpty" -> System.out.println("isEmpty : " + deque.isEmpty());
            }
        }
    }


}
