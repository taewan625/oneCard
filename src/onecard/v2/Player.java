package onecard.v2;

import java.util.LinkedList;


// v3. CardGame class에 있는 Mylist 배열을 player에 직접 넣는게 낫지 않을까? 아니면 PlayerList class를 만든다던지...
class Player {
    // v3 playerNum 직접 넣기 - int[] array사용하지 말기
    private int playerNum;
    final int[] PLAYER_NUM = {0,1,2,3,4,5,6};
    LinkedList<OneCard> playerDeck = new LinkedList<>();

    public int getPlayerNum() {
        return playerNum + 1;
    }

    public Player(int playerNum) {
        this.playerNum = playerNum;
    }

    @Override
    public String toString() {
        String player = PLAYER_NUM[playerNum] + 1 + " Player";
        return player + " : " + playerDeck ;
    }
}// Player 끝
