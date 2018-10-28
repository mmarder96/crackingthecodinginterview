package Section_3;

import java.util.ArrayList;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack
 * exceeds some threshold. Implement a data structure SetOfStacks that mimics
 * this. SetOfStacks should be composed of several stacks and should create a
 * new stack once the previous one exceeds capacity. SetOfStacks.push() and
 * SetOfStacks.pop() should behave identically to a single stack (that is, pop()
 * should return the same values as it would if there were just a single stack).
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on
 * a specific sub-stack.
 */
public class Solution_3_3 {

    public static void main(String[] args) {

        SetOfStacks set = new SetOfStacks(3);

        try {
            // Stack 1
            set.push(1);
            set.push(2);
            set.push(3);
            // Stack 2
            set.push(4);
            set.push(5);
            set.push(6);
            // Stack 3
            set.push(7);
            set.push(8);
            set.push(9);

            assert set.pop() == 9;

            assert set.popAt(0) == 3;
            assert set.popAt(0) == 2;
            assert set.popAt(0) == 1;

            assert set.popAt(0) == 6;

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

class SetOfStacks {

    ArrayList<SizeStack<Integer>> stackSet = new ArrayList<>();
    int stackCap;

    public SetOfStacks(int capacity) {
        this.stackCap = capacity;
    }

    int pop() throws Exception {
        if (stackSet.isEmpty())
            throw new Exception("Stack set is empty!");
        SizeStack<Integer> lastStack = stackSet.get(stackSet.size() - 1);
        int value = lastStack.pop(); // pop last element in last stack
        if (lastStack.size() == 0) // if the stack is now empty, remove it from the set
            stackSet.remove(lastStack);
        return value;
    }

    int popAt(int index) throws Exception {
        if (stackSet.isEmpty())
            throw new Exception("Stack set is empty!");
        SizeStack<Integer> stack = stackSet.get(index);
        int value = stack.pop(); // pop last element in desired stack
        if (stack.size() == 0) // if the stack is now empty, remove it from the set
            stackSet.remove(stack);
        return value;
    }

    void push(int item) {
        if (stackSet.isEmpty()) {     // if the stackSet is empty append a new stack and push
            stackSet.add(new SizeStack<Integer>());
            stackSet.get(stackSet.size() - 1).push(item);
        } else if (stackSet.get(stackSet.size() - 1).size() >= this.stackCap) { // if last stack is at cap add new stack and push
            stackSet.add(new SizeStack<Integer>());
            stackSet.get(stackSet.size() - 1).push(item);
        } else {    // otherwise just push to last non-capped stack
            stackSet.get(stackSet.size() - 1).push(item);
        }
    }

}

class SizeStack<T> {
    Node<T> top;
    int size = 0;

    T pop() {
        if (top != null) {
            this.size--;
            T item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }

    void push(T item) {
        this.size++;
        Node t = new Node(item);
        t.next = top;
        top = t;
    }

    T peek() {
        return top.data;
    }

    int size() {
        return this.size;
    }
}
