package Section_3;

/**
 * Write a program to sort a stack in ascending order (with biggest items on top).
 * You may use at most one additional stack to hold items, but you may not copy
 * the elements into any other data structure (such as an array). The stack supports
 * the following operations: push, pop, peek, and isEmpty.
 */
public class Solution_3_6 {

    /**
     * Brute force recursive solution
     *
     * @param stack
     * @param remainingUnsorted
     */
    static void sortStack(Stack<Integer> stack, int remainingUnsorted) {
        if (remainingUnsorted == 0) // Base case
            return;

        Stack<Integer> tempStack = new Stack<>();
        int localMin = stack.pop(); // initialize local min as top of stack
        for (int i = 1; i < remainingUnsorted - 1; i++) { // find local min in remaining unsorted stack
            if (stack.peek() < localMin) {
                tempStack.push(localMin);
                localMin = stack.pop(); // store local min in variable
            }
            tempStack.push(stack.pop()); // push other elements to temp stack
        }
        stack.push(localMin); // push local min to bottom of stack
        while (!tempStack.isEmpty()) // return other elements back to stack
            stack.push(tempStack.pop());

        sortStack(stack, remainingUnsorted - 1); // sort the remaining elements of the stack
    }

    static int getSize(Stack stack) {
        int size = 0;
        Stack tempStack = new Stack();
        while (!stack.isEmpty()) { // move elements to temp stack and increase count
            tempStack.push(stack.pop());
            size++;
        }
        while (!tempStack.isEmpty()) { // move elements back to original stack and return size
            stack.push(tempStack.pop());
        }
        return size;
    }

    /**
     * Book solution
     */
     static Stack<Integer> sort(Stack<Integer> source) {
        Stack<Integer> buffer = new Stack<>();
        while (!source.isEmpty()) {
            int tmp = source.pop(); // Step 1
            while (!buffer.isEmpty() && buffer.peek() > tmp) { // Step 2
                source.push(buffer.pop());
            }
            buffer.push(tmp); // Step 3
        }
        return buffer;
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(6);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        stack.push(3);

 //        sortStack(stack, getSize(stack));
        Stack<Integer> sorted = sort(stack);
        sorted.peek();
    }
}
