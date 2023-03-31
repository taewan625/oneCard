package onecard.v2;

public class OneCardSkill {

    // iv인 boolean의 값을 변경하기 위해서는 method 내부에서 변경했다고 변경되지 않는다. -> callStack상 method 내부에서만 작동하고 끝나기 때문
    boolean Queen(boolean playerNextTurn) {
        return !playerNextTurn;
    }

    void Jack(CardGame cardGame, boolean playerNextTurn) {
        cardGame.nextTurn(playerNextTurn);
    }

    void King(CardGame cardGame, boolean playerNextTurn){
        cardGame.nextTurn(!playerNextTurn);
    }


    int Acard(OneCard openCard, OneCard submitCard, int attackCards) {
        if (openCard.number == submitCard.number) {
            return attackCards + 3;
        }
        return 3;
    }
    int SecCard(OneCard openCard, OneCard submitCard, int attackCards) {
        if (openCard.number == submitCard.number) {
            return attackCards + 2;
        }
        return 2;
    }
//    int thrdCard(OneCard openCard, OneCard submitCard, int attackCards){
//        if (openCard.kind == submitCard.kind && (openCard.number == 0 || openCard.number == 1)) {
//            return 0;
//        }
//        return attackCards;
//    }
    int DarkCard(OneCard openCard, int attackCards) {
        // attack
        if (openCard.number == 0) {
            return attackCards + 5;
        }
        return 5;
    }
    int ColorCard(OneCard openCard, int attackCards) {
        // attack
        if (openCard.number == 0) {
            return attackCards + 5;
        }
        return 7;
    }

}