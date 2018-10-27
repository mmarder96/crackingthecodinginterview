package Section_2;

import java.util.HashSet;

/**
 * Given a circular linked list, implement an algorithm which returns the node at
 * the beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points
 * to an earlier node, so as to make a loop in the linked list.
 * EXAMPLE
 * Input: A ->B->C->D->E- > C [the same C as earlier]
 * Output: C
 */
public class Solution_2_6 {

    static Node getCyclicalNode(Node head) {
        HashSet<Node> nodeSet = new HashSet<>();
        Node n = head;
        while (n != null){
            if (!nodeSet.contains(n)){
                nodeSet.add(n);
                n = n.next;
            } else {
                return n;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node cyclical = new Node(0);
        cyclical.appendToTail(1);
        cyclical.appendToTail(2);
        cyclical.appendToTail(3);
        cyclical.appendToTail(4);
        cyclical.next.next.next.next.next = cyclical.next.next;

        Node nonCyclical = new Node(0);
        nonCyclical.appendToTail(1);
        nonCyclical.appendToTail(2);
        nonCyclical.appendToTail(3);
        nonCyclical.appendToTail(4);

        assert getCyclicalNode(cyclical).data == 2;
        assert getCyclicalNode(nonCyclical) == null;
    }
}
