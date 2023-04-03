package study;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class MyTreeSetTest {

    MyTreeSet myTreeSet = new MyTreeSet();
    int MyTreeSet(){
        myTreeSet.add(3);
        myTreeSet.add(2);
        myTreeSet.add(4);
        myTreeSet.add(4);
        myTreeSet.add(1);
        System.out.println(myTreeSet.toString());
        return myTreeSet.getSize();
    }

    @Test
    void MyTreeSetTest() {
        assertEquals(4,MyTreeSet());
    }
}