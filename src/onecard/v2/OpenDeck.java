package onecard.v2;

import java.util.LinkedList;

class OpenDeck {

    LinkedList<OneCard> openDeckList = new LinkedList<>();

    // OneCard openCard = getOpenCard() 시 현재 객체에선 줄 수 있는 값이 없어서 error 발생
    // 실제 게임 때 카드를 받은 후 openCard = openDeck.getOpenCard()로 주입 해야함
    OneCard openCard;

    OneCard getOpenCard(){
        return openDeckList.getLast();
    }

    @Override
    public String toString() {
        return openDeckList.getLast().toString();
    }
//
//    OneCard[] openOneCardArr = new OneCard[1];
//    OneCard[] changeOneCardArr;
//
//    public OpenDeck(OneCard oneCardFromOneCardDeck) {
//        openOneCardArr[0] = oneCardFromOneCardDeck;
//    }
//
//    void getCard(OneCard oneCard) {
//        // 배열 생성 - getCard는 한장씩만 받으니깐 +1 만 하기
//        changeOneCardArr = new OneCard[openOneCardArr.length + 1];
//        // 배열 복사 - 원래 카드는 두번째 칸부터 복사
//        System.arraycopy(openOneCardArr, 0, changeOneCardArr, 1, openOneCardArr.length);
//        // 배열 연결
//        openOneCardArr = changeOneCardArr;
//        // 배열 첫칸에 params로 받은 원카드 객체 추가
//        openOneCardArr[0] = oneCard;
//    }

}
