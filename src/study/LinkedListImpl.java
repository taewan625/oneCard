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
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
    }

    public void add(int data) {
        Node newNode = new Node(data); // head부터 시작해서 .next가 null일 때 해당 주소를 넣을 것이다.

        // 처음 노드가 없을 때 setting
        if (head == null) {
            head = newNode;       //  동일 Node 객체 주소가짐
            tail = newNode;       //  동일 Node 객체 주소가짐
            newNode.next = head;  // .next에 처음 Node 주소 저장
        }else {
            tail.next = newNode; // tail.next에 새로운 Node 객체 주소로 변경 -> tail과 head는 같은 주소를 가지므로 head.next값도 변경됨
            tail = newNode;      // tail과 연결된 객체 주소를 최신 것으로 변경
            tail.next = head;    // 변경된 객체의 .next는 현재 null인 상태 -> 다시 처음 객체 주소인 head와 연결시켜서 circle 만듬
        }
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
