package Resources;

public class SinglyLinkedListTest {
    public static SinglyLinkedList singlyLinkedList;

    public static void main(String[] args){

        singlyLinkedList = new SinglyLinkedList();

        // add elements to list
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);
        singlyLinkedList.add(5);

        assert singlyLinkedList.get(1).equals(2) : "Incorrect value!";
        assert singlyLinkedList.size() == 5 : "Incorrect size!";

        // remove elements
        singlyLinkedList.remove(1);

        assert singlyLinkedList.get(1).equals(3) : "Incorrect value!";
        assert singlyLinkedList.size() == 4 : "Incorrect size!";

        // set element in list
        singlyLinkedList.set(1, 2);

        assert singlyLinkedList.get(1).equals(2) : "Incorrect value!";
    }
}

class SinglyLinkedList {

    private static int counter;
    private Node head;

    // Default constructor
    public SinglyLinkedList() {

    }

    // Counter methods
    public static int getCounter() {
        return counter;
    }

    private void incrementCounter() {
        this.counter++;
    }

    private void decrementCounter() {
        this.counter--;
    }

    // Get size of linked list
    public int size() {
        return this.getCounter();
    }

    // Appends the specified element to the end of the list.
    public void add(Object data) {

        // Init Node only if 1st element
        if (head == null) {
            this.head = new Node(data);
        }

        Node tempNode = new Node(data);
        Node currentNode = head;

        // Iterate over list if head is not null
        if (currentNode != null) {
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            // Add node to end of list
            currentNode.setNext(tempNode);
        }

        // Increment number of elements;
        this.incrementCounter();
    }

    // Return value in list at specific index.
    public Object get(int index) {

        // if index must be 1 or higher
        if (index < 0) {
            return null;
        }

        Node currentNode;

        // if head is not null try to get data
        if (this.head != null) {
            currentNode = head.getNext();
            for (int i = 0; i < index; i++) {
                if (currentNode.getNext() == null)
                    return null;
                currentNode = currentNode.getNext();
            }
            return currentNode.getData();
        }

        // if head is null return null
        return null;
    }

    // Return value in list at specific index.
    public Object set(int index, Object dataValue) {

        // if index must be 1 or higher
        if (index < 0) {
            return null;
        }

        Node currentNode;

        // if head is not null try to set data at index
        if (this.head != null) {
            currentNode = head.getNext();
            for (int i = 0; i < index; i++) {
                if (currentNode.getNext() == null)
                    return null;
                currentNode = currentNode.getNext();
            }
            currentNode.setData(dataValue);
        }

        // if head is null return null
        return null;
    }


    public void remove(int index) {

        // if the index is out of range, return
        if (index < 1 || index > this.size())
            return;

        Node currentNode = this.head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (currentNode.getNext() == null)
                    return;
                currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());

            // decrement counter
            this.decrementCounter();
        }
    }

    private class Node {

        // References next node in chain
        Node next;

        // Data carried by this node.
        Object data;

        // Node constructor
        public Node(Object dataValue) {
            this.next = null;
            this.data = dataValue;
        }

        // Secondary constructor to specify the node to point to
        public Node(Object dataValue, Node nextNode) {
            this.next = nextNode;
            this.data = dataValue;
        }

        // Getters
        public Object getData() {
            return this.data;
        }

        public Node getNext() {
            return this.next;
        }

        // Setters
        public void setData(Object dataValue) {
            this.data = dataValue;
        }

        public void setNext(Node nextNode) {
            this.next = nextNode;
        }
    }
}
