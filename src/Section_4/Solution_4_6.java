package Section_4;

/**
 * Write an algorithm to find the 'next' node (i.e., in-order successor) of a given node
 * in a binary search tree. You may assume that each node has a link to its parent
 */
public class Solution_4_6 {

    static DoublyLinkedBST findNext(DoublyLinkedBST node) {
        if (node == null)
            return null;
        // if node has right subtree, return leftmost child
        if (node.right != null)
            return leftMostChild(node);
        // otherwise travel up leftward and return parent
        else {
            while (node.parent.right == node)
                node = node.parent;
            return node.parent;
        }
    }

    static DoublyLinkedBST leftMostChild(DoublyLinkedBST node) {
        if (node == null)
            return null;
        while (node.left != null)
            node = node.left;
        return node;
    }

    public static void main(String args[]) {

    }
}

class DoublyLinkedBST {

    DoublyLinkedBST parent, left, right;
    int data;

    public DoublyLinkedBST(int data) {
        this.data = data;
    }

    public DoublyLinkedBST(int data, DoublyLinkedBST parent) {
        this.data = data;
        this.parent = parent;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new DoublyLinkedBST(value, this);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new DoublyLinkedBST(value, this);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value) {
        if (value == data) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else return right.contains(value);
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(data);
        if (right != null) {
            right.printInOrder();
        }
    }

    public void printPreOrder() {
        System.out.println(data);
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
    }

    public void printPostOrder() {
        if (left != null) {
            left.printPostOrder();
        }
        if (right != null) {
            right.printPostOrder();
        }
        System.out.println(data);
    }
}

