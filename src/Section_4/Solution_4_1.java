package Section_4;

/**
 * Implement a function to check if a binary tree is balanced. For the purposes of
 * this question, a balanced tree is defined to be a tree such that the heights of the
 * two subtrees of any node never differ by more than one.
 */
public class Solution_4_1 {

    static int getDepth(BST root) {
        if (root == null) // Base case
            return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    static boolean isBalanced(BST root) {
        if (root == null) return true; // Base case

        int depthDiff = Math.abs(getDepth(root.left) - getDepth(root.right));

        if (depthDiff > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static void main(String[] args) {
        BST balancedBST = new BST(4);
        balancedBST.insert(2);
        balancedBST.insert(1);
        balancedBST.insert(4);
        balancedBST.insert(6);
        balancedBST.insert(5);
        balancedBST.insert(7);

        BST unbalancedBST = new BST(1);
        unbalancedBST.insert(2);
        unbalancedBST.insert(3);
        unbalancedBST.insert(4);
        unbalancedBST.insert(5);
        unbalancedBST.insert(6);
        unbalancedBST.insert(7);

        assert isBalanced(balancedBST) == true;
        assert isBalanced(unbalancedBST) == false;
    }
}
