package quiz;

import java.util.Objects;

public class MyVector {

    Object[] objArr = null;
    int capacity = 0;

    int size = 0;

    int capacity() {
        return objArr.length;
    }

    boolean isEmpty() {
        return size == 0 ? true : false;
    }
    int size() {
        return size;
    }

    void add(Object obj) {
        objArr[size++] = obj;
        // 배열0부터 객체 넣어주고 객체 개수도 셀 수 있다.
    }

    Object get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return objArr[index];
    }

    public MyVector() {
        this(16);
    }

    // 핵심 : Object[]를 null로 초기값을 잡았지만 생성자를 이용해서 Object 빈 배열 생성해줌
    public MyVector(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("유효하지 않은 값입니다 : " + capacity);
        }
        this.capacity = capacity;
        objArr = new Object[capacity];
    }
}
