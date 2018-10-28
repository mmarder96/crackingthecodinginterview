package Section_3;

public class Queue<T> {
    Node<T> first, last;

    void enqueue(T item) {
        if (first == null) {
            last = new Node(item);
            first = last;
        } else {
            last.next = new Node(item);
            last = last.next;
        }
    }

    T dequeue() {
        if (first != null){
            T item = first.data;
            first = first.next;
            return item;
        }
        return null;
    }
}
