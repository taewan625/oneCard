package onecard.v2;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 0; i < 10; i++) {
            myLinkedList.add(i);
        }


        int size = myLinkedList.size();
        System.out.println("size = " + size);

    }

}