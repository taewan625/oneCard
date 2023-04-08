package study;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedStackTest {
    public static void main(String[] args) {
        MyLinkedStack stack = new MyLinkedStack();
        stack.print();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.print();
    }

}