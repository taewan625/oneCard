package onecard;

import java.util.Arrays;

class Player {

    OneCard[] playerOneCardArr;
    OneCard[] changeOneCardArr;

    public Player() {
    }

    public Player(OneCard[] getCard) {
        this.playerOneCardArr = getCard;
    }

    @Override
    public String toString() {
        return Arrays.toString(playerOneCardArr);
    }

    void trashCard(int trashCardIndex) {
        // 중복 index를 이용해서 array의 제일 끝으로 보내고 임시 array에 복사후 원 array에 연결
        changeOneCardArr = new OneCard[playerOneCardArr.length - 1];
        OneCard tmp;
        tmp = playerOneCardArr[trashCardIndex];
        playerOneCardArr[trashCardIndex] = playerOneCardArr[playerOneCardArr.length - 1];
        playerOneCardArr[playerOneCardArr.length - 1] = tmp;
        System.arraycopy(playerOneCardArr, 0, changeOneCardArr, 0, playerOneCardArr.length - 1);
        playerOneCardArr = changeOneCardArr;
    }

    // 원카드 덱으로부터 받은 배열을 플레이어 배열에 넣을 것이다.
    void getCard(OneCard[] getCardArr) {
        changeOneCardArr = new OneCard[playerOneCardArr.length + getCardArr.length];
        System.arraycopy(playerOneCardArr, 0, changeOneCardArr, 0, playerOneCardArr.length);
        System.arraycopy(getCardArr, 0, changeOneCardArr, playerOneCardArr.length, getCardArr.length);
        playerOneCardArr = changeOneCardArr;
    }
}// Player 끝
