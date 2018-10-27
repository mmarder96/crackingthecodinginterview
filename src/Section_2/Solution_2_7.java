package Section_2;

import java.util.Stack;

/**
 * Implement a function to check if a linked list is a palindrome.
 */
public class Solution_2_7 {

    /**
     * Creates a reversed version of the linked list and compares it with the original.
     * If the first half of reversed is the same as the original, then the list
     * is a palindrome.
     *
     * @param head the root of the linked list
     * @return returns whether or not the supplied list is a palindrome
     */
    static Boolean isPalindrome1(Node head) {
        Node n = head.clone();
        Node reversed = null;
        while (n != null) { // Build a reversed version of the list
            Node next = n.next;
            n.next = reversed;
            reversed = n;
            n = next;
        }
        n = head; // Return the node n to the head of the list;
        Node runner = head; // Use a runner to only iterate through half of the list
        while (runner != null && runner.next != null) {
            if (n.data != reversed.data) {
                return false;
            }
            n = n.next;
            reversed = reversed.next;
            runner = runner.next.next;
        }
        return true;
    }

    static Boolean isPalindrome2(Node head) {
        Node fast = head;
        Node slow = head;

        Stack<Integer> stack = new Stack<>();

        /* Push elements from first half of linked list onto stack. When
         * fast runner (which is moving at 2x speed) reaches the end of
         * the linked list, then we know we're at the middle */
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // If the list has an odd number of elements move slow forward one step
        if (fast != null) {
            slow = slow.next;
        }

        // Continue iterating through list and compare with each element in the stack
        while (slow != null){
            int top = stack.pop().intValue(); // unbox Integer in stack
            // if the values are different, then it's not a palindrome
            if (top != slow.data){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node palindrome = new Node(0);
        palindrome.appendToTail(1);
        palindrome.appendToTail(2);
        palindrome.appendToTail(1);
        palindrome.appendToTail(0);

        Node nonPalindrome = new Node(0);
        nonPalindrome.appendToTail(1);
        nonPalindrome.appendToTail(2);
        nonPalindrome.appendToTail(3);
        nonPalindrome.appendToTail(4);

        assert isPalindrome1(palindrome) == true;
        assert isPalindrome1(nonPalindrome) == false;

        assert isPalindrome2(palindrome) == true;
        assert isPalindrome2(nonPalindrome) == false;
    }
}
