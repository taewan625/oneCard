package onecard.v2;

import java.util.LinkedList;

class OneCardDeck {
    LinkedList<OneCard> oneCardList = new LinkedList<>();

    // 카드 덱 생성
    OneCardDeck() {
        for (int k = 0; k < OneCard.KIND_MAX; k++) {
            for (int n = 0; n < OneCard.NUM_MAX; n++) {
                oneCardList.add(new OneCard(k, n));
            }
        }
        oneCardList.add(new OneCard(4,13)); // 칼라조커
        oneCardList.add(new OneCard(5,13)); // 흑백조커
    }
}