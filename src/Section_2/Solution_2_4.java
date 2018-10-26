package Section_2;

/**
 * Write code to partition a linked list around a value x, such that all nodes less than
 * x come before all nodes greater than or equal to x.
 */
public class Solution_2_4 {

    static Node partition(Node head, int value){
        Node less = null;
        Node more = new Node(head.getNode(value).data);
        head = head.deleteNode(value);
        Node n = head;

        // Partition list
        while (n != null){
            Node next = n.next;
            if (n.data < value){
                // Insert node into start of less list
                n.next = less;
                less = n;
            } else {
                // Insert node into end of more list
                more.appendToTail(n.data);
            }
            n = next;
        }

        // Merge partitions
        if (less == null){
            return more;
        }

        // Find end of less and merge
        Node merged = less;
        while (less.next != null){
            less = less.next;
        }
        less.next = more;

        return merged;
    }

    public static void main(String[] args){
        Node list = new Node(0);
        list.appendToTail(1);
        list.appendToTail(5);
        list.appendToTail(2);
        list.appendToTail(4);
        list.appendToTail(3);
        list.appendToTail(7);
        list.appendToTail(6);

        list = partition(list, 4);

        Node n = list;
        while (n != null){
            System.out.println(n.data);
            n = n.next;
        }
    }
}
