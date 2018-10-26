package Section_2;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class Solution_2_2 {

    static int getKFromLast(Node head, int k){
        Node n = head;
        Node runner = head;

        // check if k is a valid index
        if (k < 0) {
            throw new IndexOutOfBoundsException();
        }

        // move runner k nodes away from head
        for (int i=0; i<k; i++){
            // check if k is a valid index
            if (runner.next == null)
                throw new IndexOutOfBoundsException();
            runner = runner.next;
        }

        // move runner to tail and increment current node
        while (runner.next != null) {
            runner = runner.next;
            n = n.next;
        }

        return n.data;
    }

    public static void main(String[] args) {
        Node n = new Node(0);
        n.appendToTail(1);
        n.appendToTail(2);
        n.appendToTail(3);
        n.appendToTail(4);
        n.appendToTail(5);

        assert getKFromLast(n, 0) == 5;
        assert getKFromLast(n, 1) == 4;
        assert getKFromLast(n, 2) == 3;
        assert getKFromLast(n, 3) == 2;
        assert getKFromLast(n, 4) == 1;
        assert getKFromLast(n, 5) == 0;
    }
}
