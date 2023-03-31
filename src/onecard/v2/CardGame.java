package onecard.v2;

public class CardGame {
    MyLinkedList playerLinkedList = new MyLinkedList();

    void playerList(int playerNum) {
        for (int i = 0; i < playerNum; i++) {
            Player player = new Player(i);
            playerLinkedList.add(player);
        }
    }


    Player getPlayer(int index){
        Player player = (Player) (playerLinkedList.get(index)).data;
        return player;
    }


    void nextTurn(boolean bool) {
        if (bool) {
            playerLinkedList.next();
        } else {
            playerLinkedList.prev();
        }
    }



} // class 끝