package Section_3;

public class Stack<T> {
    Node<T> top;

    T pop() {
        if (top != null) {
            T item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }

    void push(T item) {
        Node t = new Node(item);
        t.next = top;
        top = t;
    }

    T peek() {
        if (top != null)
            return top.data;
        return null;
    }

    Boolean isEmpty(){
        if (top == null)
            return true;
        return false;
    }
}
