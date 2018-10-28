package Section_3;

import java.util.Stack;

/**
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
 * different sizes which can slide onto any tower. The puzzle starts with disks sorted
 * in ascending order of size from top to bottom (i.e., each disk sits on top of an even
 * larger one). You have the following constraints:
 * (T) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto the next rod.
 * (3) A disk can only be placed on top of a larger disk.
 * Write a program to move the disks from the first tower to the last using Stacks.
 */
public class Solution_3_4 {

    public static void main(String[] args) {
        int n = 10;
        Tower[] towers = new Tower[n];
        for (int i = 0; i < 3; i++)
            towers[i] = new Tower();
        for (int i = n - 1; i >= 0; i--) {
            try {
                towers[0].add(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        towers[0].moveDisks(n, towers[2], towers[1]);

        // Assert the disks were moved appropriately
        for (int i = 0; i < n; i++) {
            assert towers[2].disks.pop() == i;
        }
    }
}

class Tower {

    Stack<Integer> disks;

    public Tower() {
        this.disks = new Stack<Integer>();
    }

    public void add(int d) throws Exception {
        if (!disks.isEmpty() && disks.peek() <= d) {
            throw new Exception("Error placing disk" + d);
        } else {
            disks.push(d);
        }
    }

    public void moveTopTo(Tower t) {
        try {
            int top = disks.pop();
            t.add(top);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveDisks(int n, Tower destination, Tower buffer) {
        if (n > 0) {
            moveDisks(n - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }
}
