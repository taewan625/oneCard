package onecard.v2;

import java.util.LinkedList;

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

//    OneCard[] playerOneCardArr;
//    OneCard[] changeOneCardArr;
//
//    public Player() {
//    }
//
//    public Player(OneCard[] getCard) {
//        this.playerOneCardArr = getCard;
//    }
//

//
//    void trashCard(int trashCardIndex) {
//        // 중복 index를 이용해서 array의 제일 끝으로 보내고 임시 array에 복사후 원 array에 연결
//        changeOneCardArr = new OneCard[playerOneCardArr.length - 1];
//        OneCard tmp;
//        tmp = playerOneCardArr[trashCardIndex];
//        playerOneCardArr[trashCardIndex] = playerOneCardArr[playerOneCardArr.length - 1];
//        playerOneCardArr[playerOneCardArr.length - 1] = tmp;
//        System.arraycopy(playerOneCardArr, 0, changeOneCardArr, 0, playerOneCardArr.length - 1);
//        playerOneCardArr = changeOneCardArr;
//    }
//
//    // 원카드 덱으로부터 받은 배열을 플레이어 배열에 넣을 것이다.
//    void getCard(OneCard[] getCardArr) {
//        changeOneCardArr = new OneCard[playerOneCardArr.length + getCardArr.length];
//        System.arraycopy(playerOneCardArr, 0, changeOneCardArr, 0, playerOneCardArr.length);
//        System.arraycopy(getCardArr, 0, changeOneCardArr, playerOneCardArr.length, getCardArr.length);
//        playerOneCardArr = changeOneCardArr;
//    }
}// Player 끝
