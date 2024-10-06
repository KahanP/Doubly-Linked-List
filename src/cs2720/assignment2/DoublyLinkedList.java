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

            if (item.equals(current.info)) {
                System.out.println("Item already exists");
                return;
            }
            newNode.next = current;
            newNode.back = current.back;
            current.back.next = newNode;
            current.back = newNode;
        } // if/else

    } // insertItem

    public void deleteItem(T item) {

        if (this.head == null) {
            System.out.println("You cannot delete from an empty list");
            return;
        } // null check

        NodeType<T> current = this.head;
        if (item.equals(current.info)) {
            if (current.next == null) {
                this.head = null;
            } else {
                this.head = current.next;
                this.head.back = null;
            } // if/else
            return;
        } // check if head needs to be deleted

        // traverse the list to find the node
        while (current != null && !item.equals(current.info)) {
            current = current.next;
        } // while

        if (current == null) {
           System.out.println("The item is not present in the list");
          return;
        } //  if

        if (current != null) {
            if (current.next != null) {
                current.next.back = current.back;
            } // if
            if (current.back != null) {
                current.back.next = current.next;
            }
        } // delete the node
        if (current == this.tail) {
            this.tail = current.back;
        } // update the tail

    } // deleteItem

    public int length() {

        int length = 0;

        if (head == null) {
            return length;
        }
        NodeType<T> current = head;
        while (current != null) {
            current = current.next;
            length++;
        } // count nodes

        return length;
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
        if (this.head == null) {
            System.out.print(" ");
        }
        NodeType<T> current = this.tail;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.back;

        } // traverse list
        System.out.println("");

    } // printreverse

    public void reverseList() {
        if (this.head == null) {
            System.out.print(" ");
        } // check if list exists
        NodeType<T> current = this.tail;
        while (current != null) {
            NodeType<T> temp = current.next; // store next node
            current.next = current.back; // swap next and back pointers
            current.back = temp; // assign stored next to back
            current = current.next; // move to next node
        } // reversal
        // swap head and tail
        NodeType<T> tempHead = this.head;
        this.head = this.tail;
        this.tail = tempHead;

        if (this.head != null) {
            this.head.back = null;
        } // set new head back to null
        if (this.tail != null) {
            this.tail.next = null;
        } // set tail next to null

    } // reverseList

    public void deleteSubsection(T lowerBound, T upperBound) {
        if (this.head == null) {
            System.out.println(" ");
        } // check if list exists

        // start from the head
        NodeType<T> current = this.head;

        // loop through the list
        while (current != null) {
            if (current.info.compareTo(lowerBound) >= 0 && current.info.compareTo(upperBound) <= 0){
                NodeType<T> toDelete = current; // node to be deleted
                current = current.next; // move to next node before deletion

                if (toDelete == head) { // if the node to be deleted is the head of the list
                    head = head.next;
                    if (head != null) {
                        head.back = null;
                    } else {
                        tail = null;
                    }
                } else if (toDelete == tail) { // if the node to be deleted is the tail of the list
                    tail = tail.back;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else { // if the node to be deleted is in the middle of the list
                    toDelete.back.next = toDelete.next;
                    toDelete.next.back = toDelete.back;
                }
            } else {
                current = current.next;
            }
        } // while

    } // deleteSubsection

    public void swapAlternate() {
        // checks if the list is empty or only has one element
        if (this.head == null || this.head.next == null) {
            return; // exits as no swap required with no or one element
        }

        // current points to the head of the list
        NodeType<T> current = this.head;

        // loop through the list
        while (current != null && current.next != null) {
            T temp = current.info; // store the val of the current node
            current.info = current.next.info; // replace current node's value with next node's value
            current.next.info = temp; // set's the next node's value to the original current node's
            current = current.next.next; // move to the node after next to continue swapping
        }
    } // swapAlternate

} // DoublyLinkedList
