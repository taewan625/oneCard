package onecard.v2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Dealer {

    // OneCardDeck과 같은 경우는 공유하는 부분들이 많아서 오히려 객체 생성 후 밖으로 빼는 것이 효율적이다.
    // 또한 OneCardDeck은 deck으로써의 의미 밖에 없어서 Dealer말고는 사용하는 class가 없다.
    OneCardDeck oneCardDeck = new OneCardDeck();

    void shuffleOneCardDeck() {
        LinkedList<OneCard> oneCardList = oneCardDeck.oneCardList;
        Collections.shuffle(oneCardList);
    }

//    해당 giveCard는 실제 게임을 돌리게 되면 player에게 sublist해서 카드 주는 코드를 매번 작성하게 된다.
//    List<OneCard> giveCard(int giveNum) {
//        LinkedList<OneCard> oneCardList = oneCardDeck.oneCardList;
//        return oneCardList.subList(0, giveNum);
//    }
    void giveCard(OpenDeck openDeck, int cards) {
        LinkedList<OneCard> openDeckList = openDeck.openDeckList;
        List<OneCard> oneCards = oneCardDeck.oneCardList.subList(0, cards);
        openDeckList.addAll(oneCards);

        LinkedList<OneCard> copyOneCards = new LinkedList<>(oneCards);
        oneCardDeck.oneCardList.removeAll(copyOneCards);
    }

    void giveCard(Player player, int cards) {
        // 중요 ->  매개변수를 잘 이용하면 class 안에 다른 class의 객체를 생성하지 않아도 해당 method처럼 활용이 가능하다.
        LinkedList<OneCard> playerDeck = player.playerDeck;
        List<OneCard> oneCards = oneCardDeck.oneCardList.subList(0, cards);
        playerDeck.addAll(oneCards);

        /**
         * removeAll()에 oneCards 사용시 :
         * removeAll() 메서드가 실행되는 동안 반복자가 여전히 해당 컬렉션의 요소를 탐색
         * 컬렉션을 수정하면서 동시에 해당 컬렉션을 탐색하는 경우 발생할 수 있는 ConcurrentModificationException 발생
         * 해결 :
         * 복사본을 만들어서 복사본에서 removeAll() 수행
         */
        LinkedList<OneCard> copyOneCards = new LinkedList<>(oneCards);
        oneCardDeck.oneCardList.removeAll(copyOneCards);
    }

    void getCard(OpenDeck openDeck, Player player, OneCard submitCard) {
        // 중요 ->  매개변수를 잘 이용하면 class 안에 다른 class의 객체를 생성하지 않아도 해당 method처럼 활용이 가능하다.
        LinkedList<OneCard> playerDeck = player.playerDeck;
        playerDeck.remove(submitCard);
        openDeck.openDeckList.add(submitCard);
    }


    void resetCard(OpenDeck openDeck){
        // openDeck의 마지막 카드를 제외하고 다 oneCardDeck에 주고 shuffle 하기
        int size = openDeck.openDeckList.size();
        List<OneCard> oneCards = openDeck.openDeckList.subList(0, size - 1);
        oneCardDeck.oneCardList.addAll(oneCards);

        LinkedList<OneCard> copyOneCards = new LinkedList<>(oneCards);
        openDeck.openDeckList.removeAll(copyOneCards);
        shuffleOneCardDeck();
    }


}
