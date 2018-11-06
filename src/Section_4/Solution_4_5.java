package Section_4;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class Solution_4_5 {

    static boolean isBST(BST root, int min, int max) {
        if (root == null)
            return true;
        if (root.data <= min || root.data >  max)
            return false;
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    public static void main(String[] args){
        BST bst = new BST(1);
        bst.insert(0);
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);

        assert isBST(bst, Integer.MIN_VALUE, Integer.MAX_VALUE) == true;

        bst.left.data = 8;
        assert isBST(bst, Integer.MIN_VALUE, Integer.MAX_VALUE) == false;
    }
}
