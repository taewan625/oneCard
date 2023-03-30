package quiz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyVectorTest {
    MyVector myVector = new MyVector();

    int capacity() {
        return myVector.capacity;
    }

    boolean isEmpty() {
        return myVector.isEmpty();
    }

    int capacityObj(int capacity) {
        MyVector myVector = new MyVector(capacity);

        return myVector.capacity();
    }


    @Test
    void capacityTest() {
        assertEquals(16, capacity());
    }

    @Test
    void isEmptyTest() {
        assertTrue(isEmpty());
    }

    @Test
    void objCapacityTest() {
        assertEquals(14,capacityObj(14));
        assertEquals(1,capacityObj(1));
        assertEquals(0,capacityObj(0));
        assertThrows(IllegalArgumentException.class, ()->capacityObj(-3));
    }

}