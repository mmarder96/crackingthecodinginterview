package Section_3;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 */
public class Solution_3_5 {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        assert queue.peek() == 0;

        assert queue.dequeue() == 0;
        assert queue.dequeue() == 1;
        assert queue.dequeue() == 2;
        assert queue.dequeue() == 3;
        assert queue.dequeue() == 4;
    }
}

class MyQueue<T> {

    Stack<T> queueStack, tempStack;

    public MyQueue() {
        queueStack = new Stack<>();
        tempStack = new Stack<>();
    }

    void enqueue(T item) {
        queueStack.push(item);
    }

    T dequeue() {
        while (queueStack.peek() != null) {
            tempStack.push(queueStack.pop());
        }
        T value = tempStack.pop();
        while (tempStack.peek() != null) {
            queueStack.push(tempStack.pop());
        }
        return value;
    }

    T peek() {
        while (queueStack.peek() != null) {
            tempStack.push(queueStack.pop());
        }
        T value = tempStack.peek();
        while (tempStack.peek() != null) {
            queueStack.push(tempStack.pop());
        }
        return value;
    }
}
