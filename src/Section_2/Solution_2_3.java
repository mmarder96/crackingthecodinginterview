package Section_2;

/**
 * Implement an algorithm to delete a node in the middle of a singly linked list,
 * given only access to that node.
 * EXAMPLE
 * Input: the node c from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a- >b- >d->e
 *
 * Note that this problem cannot be solved if the node to be deleted is the last node in
 * the linked list. That's ok—your interviewer wants you to point that out, and to discuss
 * how to handle this case. You could, for example, consider marking the node as dummy.
 */
public class Solution_2_3 {

    static boolean deleteNode(Node n){
        if (n == null || n.next == null){
            return false; // failure state
        }
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    public static void main(String[] args) {
        Node list = new Node(0);
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(4);
        list.appendToTail(5);

        // delete middle node
        Node deleteMe = list.next.next.next;
        deleteNode(deleteMe);

        assert list.next.next.next.data == 3;
    }
}
