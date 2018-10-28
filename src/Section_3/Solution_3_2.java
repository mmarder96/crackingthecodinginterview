package Section_3;

/**
 * How would you design a stack which, in addition to push and pop, also has a
 * function min which returns the minimum element? Push, pop and min should
 * all operate in O(1) time.
 */
public class Solution_3_2 {

    public static void main(String[] args) {
        MinStack stack = new MinStack();

        try {
            stack.push(4);
            stack.push(2);
            stack.push(5);
            stack.push(1);
            stack.push(6);

            assert stack.min() == 1;

            stack.pop();
            stack.pop();

            assert stack.min() == 2;

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

class MinStack {
    Node<Integer> top;
    int minValue = Integer.MAX_VALUE;
    Stack<Integer> minStack = new Stack<>();

    int pop() throws Exception{
        if (top == null) {
            throw new Exception("Stack is empty!");
        }
        minStack.pop();

        int item = top.data;
        top = top.next;
        return item;
     }

    void push(int item) {
        if (item < minValue){
            minValue = item;
        }
        minStack.push(minValue);

        Node t = new Node(item);
        t.next = top;
        top = t;
    }

    int peek() {
        return top.data;
    }

    int min() {
        return minStack.peek();
    }
}

