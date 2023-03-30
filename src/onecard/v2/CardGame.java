package onecard.v2;

public class CardGame {
    MyLinkedList playerLinkedList = new MyLinkedList();

    void playerList(int playerNum) {
        for (int i = 0; i < playerNum; i++) {
            Player player = new Player(i);
            playerLinkedList.add(player);
        }
//        playerLinkedList.print(); // 일단 났두고 나중에 지울 것
    }





} // class 끝


