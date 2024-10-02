package cs2720.assignment2;

public class DoublyLinkedList<T extends Comparable<T>> {

    private NodeType<T> head;
    private NodeType<T> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    } // constructor

    public void insertItem(T item) {

        NodeType<T> newNode = new NodeType<>();
        newNode.info = item;

        // Case 1: List is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = null;
            newNode.back = null;
        } else if (item.compareTo(head.info) < 0) { // Case 2: Node is smaller than head
            newNode.next = head;
            head.back = newNode;
            newNode.back = null;
            head = newNode;

        } else if (item.compareTo(tail.info) > 0) { // Case 3: Node is larger than tail
            tail.next = newNode;
            newNode.back = tail;
            newNode.next = null;
            tail = newNode;
        } else { // Case 4: Traverse list
            NodeType<T> current = head;

            while (current != null && item.compareTo(current.info) > 0) {
                current = current.next;
            } // traverse the list
            newNode.next = current;
            newNode.back = current.back;
            current.back.next = newNode;
            current.back = newNode;
        } // if/else

    } // insertItem

    public void deleteItem(T item) {

    } // deleteItem

    public int length() {
        return -1;
    } // length

    public void print() {

        if (this.head == null) {
            System.out.print(" ");
        }
        NodeType<T> current = this.head;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;

        } // traverse list
        System.out.println("");
    } // print

    public void printReverse() {

    } // printreverse

    // deleteSubsection

    // reverseList

    // swapAlternate

} // DoublyLinkedList
