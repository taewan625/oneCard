package onecard.v2;

import java.util.LinkedList;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private Node current;

    public void setCurrent(Node node) {
        current = node;
    }

    public Node getCurrent() {
        return current;
    }

    public Node getHead() {
        return head;
    }

    public void add(Object data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            head.prev = tail;
            tail.next = head;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = head;
            head.prev = tail;
        }
    }

    public void remove(Object data) {
        if (head == null) {
            System.out.println("Doubly circular linked list is empty");
            return;
        }

        Node current = head;

        // Case 1: If head node itself holds the key to be deleted
        if (current.data == data) {
            head = head.next;
            head.prev = tail;
            tail.next = head;
            return;
        }

        // Case 2: Search for the key to be deleted, keep track of the previous node
        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Key not found in the list");
            return;
        }

        // Case 3: Delete the node
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // If tail node is deleted
        if (current == tail) {
            tail = current.prev;
            tail.next = head;
            head.prev = tail;
        }
    }

    public void next() {
        if (current == null) {
            System.out.println("Current node is null");
            return;
        }

        current = current.next;
    }

    public void prev() {
        if (current == null) {
            System.out.println("Current node is null");
            return;
        }

        current = current.prev;
    }

    void print() {
        if (head == null) {
            System.out.println("빈 리스트");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);

        System.out.println();
    }

    int size() {
        if (head == null) {
            System.out.println("빈 리스트");
            return 0;
        }

        Node current = head;
        int size = 0;

        do {
            current = current.next;
            size++;
        } while (current != head);

        return size;
    }


    public Node get(int index) {
        if (index < 0) {
            System.out.println("Index cannot be negative");
            return null;
        }

        Node current = head;
        int i = 0;

        while (i < index && current.next != head) {
            current = current.next;
            i++;
        }

        if (i == index) {
            return current;
        } else {
            System.out.println("Index out of range");
            return null;
        }
    }

}





class Node {
    Object data;
    Node next;
    Node prev;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return data + "";
    }
}