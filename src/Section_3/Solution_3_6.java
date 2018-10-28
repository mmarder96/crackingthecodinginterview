package Section_3;

public class Solution_3_6 {

    static Stack sortStack(Stack stack) {
        Stack tempStack = new Stack();
        int pointer = 0;
        int localMin;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(6);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        stack.push(3);

        sortStack(stack);
    }
}
