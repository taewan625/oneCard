package study;

public class LinkedListImpl {
    public static void main(String[] args) {}
}
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
    @Override
    public String toString() {
        return data + "";
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void add(int data) {
        Node newNode = new Node(data); // head부터 시작해서 .next가 null일 때 해당 주소를 넣을 것이다.

        // 처음 노드가 없을 때 setting
        if (head == null) {
            head = newNode;
            return;
        }

        // tmp라는 Node에 임시적으로 head 주소를 넣어서 .next가 null일 때 까지 계속 주소값을 덮어 쓸 것이다.
        Node tmp = head;
        // node객체의 .next가 null일 때까지 .next에 저장되어있는 node객체주소로 tmp주소를 변경
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        // tmp 참조변수 안에는 실제 Node 객체의 주소가 들어있다. 그래서 tmp.next에 값을 넣어주면 실제 객체의 .next 값이 변한다.
        tmp.next = newNode;
    }

    Node get(int index) {
        Node curr = head;
        if (index == 0) {
//            System.out.println("curr = " + curr);
            return curr;
        }
        for (int i = 1; i <= index; i++) {
            curr = curr.next;
        }
//        System.out.println("curr = " + curr);
        return curr;
    }

}
