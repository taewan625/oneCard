package study;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LinkedListTest {
    boolean LinkedListImpl(int a, int b) {
        LinkedList list = new LinkedList();

        // list 개수 추가
        for (int i = 0; i < a; i++) {
            list.add(i);
        }
        // 5번째 Node의 toString 값
        // Linked되어있지 않으면 예외가 터진다. Linked되어있으면 true 반환
        // a>=b인 경우만 true, - 마지막 Node의 next가 null이기 때문
        for (int i = 0; i < b; i++) {
            list.get(i);
        }
        return true;
    }

    @Test
    void addCorrect() {
        assertTrue(LinkedListImpl(8, 4));
        assertTrue(LinkedListImpl(8, 8));
        assertTrue(LinkedListImpl(8, 1));
        assertTrue(LinkedListImpl(1, 1));
        // True인 이유는 마지막 노드는 null 다음 Node로 연결하기 때문
        assertTrue(LinkedListImpl(7, 8));
    }
    @Test
    void addOverNum(){
        assertThrows(NullPointerException.class, () -> LinkedListImpl(1, 8));
        assertThrows(NullPointerException.class, () -> LinkedListImpl(6, 8));
    }
}