package Section_4;

public class Solution_4_1 {

    static int getDepth(BST root) {
        if (root == null) // Base case
            return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    static boolean isBalanced(BST root) {

    }

    static void main(String[] args) {

    }
}
