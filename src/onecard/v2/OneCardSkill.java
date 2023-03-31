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


    int Acard(OneCard openCard, OneCard submitCard, int cards) {
        if (openCard.number == submitCard.number) {
            return cards + 3;
        }
        return 3;
    }
    int DarkCard(OneCard openCard, int cards) {
        // attack
        if (openCard.number == 0) {
            return cards + 5;
        }
        return 5;
    }
    int ColorCard(OneCard openCard, int cards) {
        // attack
        if (openCard.number == 0) {
            return cards + 5;
        }
        return 7;
    }

}