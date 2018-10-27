package Section_2;

/**
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1's digit is at the
 * head of the list. Write a function that adds the two numbers and returns the sum
 * as a linked list.
 * EXAMPLE
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
 * Output: 2 -> 1 -> 9.That is, 912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295.
 * Output: 9 -> 1 -> 2.That is, 912.
 */
public class Solution_2_5 {

    static int convertToNum(Node n){
        int num = 0;
        int factor = 1;
        while (n != null){
            num += n.data * factor;
            factor *= 10;
            n = n.next;
        }
        return num;
    }

    static Node convertToNode(int i){
        Node num = null;
        String numString = Integer.toString(i);
        for (char ch : numString.toCharArray()){
            Node next = num;
            num = new Node(Character.getNumericValue(ch));
            num.next = next;
        }
        return num;
    }

    static Node addNodes(Node n1, Node n2){
        int sum = convertToNum(n1)+convertToNum(n2);
        Node result = convertToNode(sum);
        return result;
    }

    public static void main(String[] args){
        Node n617 = new Node(7);
        n617.appendToTail(1);
        n617.appendToTail(6);

        Node n295 = new Node(5);
        n295.appendToTail(9);
        n295.appendToTail(2);

        Node sum = addNodes(n617, n295);
        while (sum != null){
            System.out.println(sum.data);
            sum = sum.next;
        }
    }
}
