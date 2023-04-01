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


    int ACard(OneCard openCard, int attackCards) {
        if (openCard.number == 0 || openCard.number == 1 ) {
            return attackCards + 3;
        }
        return 3;
    }
    int SecCard(OneCard openCard, int attackCards) {
        if (openCard.number == 1) {
            return attackCards + 2;
        }
        return 2;
    }
    int thrCard(){
        return 0;
    }

    int DarkCard(OneCard openCard, int attackCards) {
        // attack
        if (openCard.number == 0 || openCard.number == 1) {
            return attackCards + 5;
        }
        return 5;
    }
    int ColorCard(OneCard openCard, int attackCards) {
        // attack
        if (openCard.number == 0 || openCard.number == 1 || openCard.kind == 5) {
            return attackCards + 7;
        }
        return 7;
    }

}