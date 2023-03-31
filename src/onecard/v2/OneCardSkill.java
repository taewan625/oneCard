package onecard.v2;

public class OneCardSkill {
//    void OrderChange(int submitCardNum) {
//
//    }

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



}