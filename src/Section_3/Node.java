package Section_3;

/**
 * A simple singly linked list class for use in section 2 problems.
 */
public class Node<T> implements Cloneable{
    T data;
    Node next = null;

    public Node(T d) {
        this.data = d;
    }

    void appendToTail(T d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    Node deleteNode(T d) {
        Node n = this;

        if (n.data == d) {
            return this.next; // moved head
        }

        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return this; // head didn't change
            }
            n = n.next;
        }

        return this;
    }

    Node getNode(T d){
        Node n = this;

        if (n.data == d) {
            return this;
        }

        while (n.next != null) {
            if (n.next.data == d) {
                return n.next;
            }
            n = n.next;
        }

        return null;
    }

    @Override
    public Node clone() {
        Node node = null;
        try {
             node = (Node) super.clone();
        } catch (CloneNotSupportedException e) {
            node = new Node(this.data);
        }
        if (node.next != null){
            node.next = this.next.clone();
        }
        return node;
    }
}
