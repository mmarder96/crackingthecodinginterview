package Section_3;

import java.util.Arrays;

/**
 * Describe how you could use a single array to implement three stacks.
 */
public class Solution_3_1 {

    public static void main(String[] args) {
        MyStackArray stack = new MyStackArray(3, 3);
        try {
            // Insert elements into stacks
            stack.push(0, 1);
            stack.push(0, 2);
            stack.push(0, 3);

            stack.push(1, 4);
            stack.push(1, 5);
            stack.push(1, 6);

            stack.push(2, 7);
            stack.push(2, 8);
            stack.push(2, 9);

            // Peek each stack
            assert stack.peek(0) == 3;
            assert stack.peek(1) == 6;
            assert stack.peek(2) == 9;

            // Pop each stack
            assert stack.pop(0) == 3;
            assert stack.pop(1) == 6;
            assert stack.pop(2) == 9;

            // Assert new tops after pop
            assert stack.peek(0) == 2;
            assert stack.peek(1) == 5;
            assert stack.peek(2) == 8;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * We can divide the array in three equal parts and allow the individual stack to grow in
 * that limited space. Note: we will use the notation "[" to mean inclusive of an end point
 * and "(" to mean exclusive of an end point.
 * • For stack 1, we will use [0, n/3).
 * • For stack2, we will use [n/3, 2n/3).
 * • For stacks, we will use [2n/3, n).
 */
class MyStackArray {

    int stackSize; // the size of each stack
    int[] array; // the buffer that contains the stacks
    int[] stackPointer; // pointers to track relative top element index

    // Default constructor
    public MyStackArray() {
        this.stackSize = 100;
        this.array = new int[stackSize * 3];
        this.stackPointer = new int[3];
        Arrays.fill(stackPointer, -1);
    }

    // Custom constructor to change the number and size of stacks
    public MyStackArray(int numStacks, int stackSize) {
        this.stackSize = stackSize;
        this.array = new int[stackSize * numStacks];
        this.stackPointer = new int[numStacks];
        Arrays.fill(stackPointer, -1);
    }

    void push(int stackNum, int value) throws Exception {
        // Check if we have enough space
        if (stackPointer[stackNum] + 1 >= stackSize) {
            throw new Exception("Out of space!");
        }
        // Increment stack pointer and update top value
        stackPointer[stackNum]++;
        array[getTopStackIndex(stackNum)] = value;
    }

    int pop(int stackNum) throws Exception {
        if (isEmpty(stackNum)) {
            throw new Exception("Stack is empty!");
        }
        // Decrement stack pointer, clear index, and return top value
        int value = array[getTopStackIndex(stackNum)];
        array[getTopStackIndex(stackNum)] = 0;
        stackPointer[stackNum]--;
        return value;
    }

    int peek(int stackNum) throws Exception {
        // Check if stack is empty
        if (isEmpty(stackNum)) {
            throw new Exception("Stack is empty!");
        }
        return array[getTopStackIndex(stackNum)];
    }

    boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == -1;
    }

    int getTopStackIndex(int stackNum) {
        return stackNum * stackSize + stackPointer[stackNum];
    }
}
