package Section_4;

import java.util.Arrays;

/**
 * Given a sorted (increasing order) array with unique integer elements, write an
 * algorithm to create a binary search tree with minimal height.
 */
public class Solution_4_3 {

    static BST createMinimalBST(int[] array) {
        Arrays.sort(array);
        BST bst = createMinimalBSTUtil(array, 0, array.length - 1);
        return bst;
    }

    static BST createMinimalBSTUtil(int[] array, int start, int end) {
        if (end < start) { // Base case
            return null;
        }
        int mid = (start + end) / 2;
        BST n = new BST(array[mid]);
        n.left = createMinimalBSTUtil(array, start, mid - 1);
        n.right = createMinimalBSTUtil(array, mid + 1, end);
        return n;

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        BST bst = createMinimalBST(array);
        bst.printInOrder();
    }
}
