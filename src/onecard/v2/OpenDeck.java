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

}
