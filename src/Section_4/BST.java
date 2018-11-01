package Section_4;

class BST {

    BST left, right;
    int data;

    public BST(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new BST(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new BST(value);
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