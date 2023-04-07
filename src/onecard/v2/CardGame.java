package onecard.v2;

import java.util.Scanner;

public class CardGame {
    Scanner scanner = new Scanner(System.in);
    MyLinkedList playerLinkedList = new MyLinkedList(); // v3. 얘도 Player 쪽으로 가는게 나을 듯
    OneCardSkill oneCardSkill = new OneCardSkill();

    int attackCards = 0;
    int kindNum;
    boolean skillBoolean = false;
    boolean sevenBoolean = false;

    // v3. Player class랑 myLinkedList랑 관계를 엮는게 나을 거 같은데.. 여기랑 안어울림
    void playerList(int playerNum) {
        for (int i = 0; i < playerNum; i++) {
            Player player = new Player(i);
            playerLinkedList.add(player);
        }
    }


    Player getPlayer(int index){
        Player player = (Player) (playerLinkedList.get(index)).data;
        return player;
    }


    void nextTurn(boolean bool) {
        if (bool) {
            playerLinkedList.next();
        } else {
            playerLinkedList.prev();
        }
    }

    // skill card
    void checkAttackCard(int cardNum, int cardKind, OneCard openCard) {
        switch (cardNum) {
            case 0: //A card
                attackCards = oneCardSkill.ACard(openCard, attackCards);
                break;
            case 1: //2 card
                attackCards = oneCardSkill.SecCard(openCard, attackCards);
                break;
            case 2: //3 card
                attackCards = oneCardSkill.thrCard();
                break;
        }

        switch (cardKind) {
            case 4://ColorJoker
                attackCards = oneCardSkill.ColorCard(openCard, attackCards);
                break;
            case 5://DarkJoker
                attackCards = oneCardSkill.DarkCard(openCard, attackCards);
                break;
        }
    }
    // skill order card
    boolean checkOrderSkillCard(int cardNum, CardGame cardGame, boolean playNextTurn) {
        switch (cardNum) {
            case 10://Jack card
                oneCardSkill.Jack(cardGame, playNextTurn);
                break;
            case 11://Queen card
                return oneCardSkill.Queen(playNextTurn);
            case 12://King card
                oneCardSkill.King(cardGame, playNextTurn);
                break;
        }
        return playNextTurn;
    }

    // 주어진 범위의 카드인지, 제출한 카드가 올바른 카드인지, -1일 때(seven true/false) 조건에 맞게 비교하는지 확인하는 filter
    boolean submittedCardFilter(int submitCardIndex, OneCard submitCard, OneCard openCard, Player currentPlayer, Dealer dealer){
        //7번 카드가 직전에 나왔을 때 조건 생성
        int choiceKind = sevenBoolean==true ? kindNum : openCard.kind;
        if (submitCardIndex == -1) {
            System.out.println("제출할 카드가 없어서 카드 한 장 가져옵니다.");
            dealer.giveCard(currentPlayer, 1);
            return false;
        } else if ((submitCard.kind == 4 && (choiceKind == 1 || choiceKind == 2)) ||
                (submitCard.kind == 5 && (choiceKind == 0 || choiceKind == 3))) {
            // 카드 정상 제출 후 openCard.kind로 부터 가져와야함
            sevenBoolean = false;
            return false;
        } else if ((choiceKind == 4 && (submitCard.kind == 1 || submitCard.kind == 2)) ||
                (choiceKind == 5 && (submitCard.kind == 0 || submitCard.kind == 3))) {
            // 카드 정상 제출 후 openCard.kind로 부터 가져와야함
            sevenBoolean = false;
            return false;
        } else if (0 > submitCardIndex || submitCardIndex >= currentPlayer.playerDeck.size()) {
            System.out.println("주어진 범위 내의 숫자를 작성하세요");
            return true;
        } else if (submitCard.kind != choiceKind && submitCard.number != openCard.number) {
            System.out.println("올바르지 않은 카드입니다. 다시 제출하세요");
            return true;
        }
        // -1과 return이 true 가 아닌 한 openCard.kind로 부터 가져와야함
        sevenBoolean = false;
        return false;
    }
    // 직전 제출카드가 skillCard 일때 filter 조건
    boolean skillSubmittedCardFilter(int submitCardIndex, OneCard submitCard, OneCard openCard, Player currentPlayer, Dealer dealer){
        if (submitCardIndex == -1 || openCard.kind == 4) {
            System.out.println("제출할 카드가 없어서 패널티카드를 가져오고 턴이 종료됩니다.");
            dealer.giveCard(currentPlayer, attackCards);
            skillBoolean = false;
            attackCards = 0;
            return false;
        } else if (openCard.number == 0 && (submitCard.number == 0 || submitCard.kind == 4 || submitCard.kind == 5)) {
            return false;
        } else if (openCard.number == 1 && (submitCard.number == 0 || submitCard.number == 1 || submitCard.number == 2
                || submitCard.kind == 4 || submitCard.kind == 5)) {
            return false;
        } else if (openCard.kind == 5 && submitCard.kind == 4) {
            return false;
        } else if (0 > submitCardIndex || submitCardIndex >= currentPlayer.playerDeck.size()) {
            System.out.println("주어진 범위 내의 숫자를 작성하세요");
            return true;
        }
        System.out.println("올바르지 않은 카드입니다. 다시 제출하세요");
        return true;
    }

    // 특수카드 발동 안할 때 게임 진행 - attackCard = 0, j , q , k
    boolean gameRunning(OneCard submitCard, CardGame cardGame, boolean playNextTurn, OneCard openCard) {
        // 제출한 카드에 특수 기능이 포함 되었을 때 - method
        // 일반 카드일 때 // 순서카드일 때 // 7 번 카드일 때 // 공격카드일 때 -> 기능 수행
        int cardNum = submitCard.number;
        int cardKind = submitCard.kind;

        if (cardNum == 10 || cardNum == 11 || cardNum == 12) {
            return checkOrderSkillCard(cardNum, cardGame, playNextTurn);
        }
        if (cardNum == 0 || cardNum == 1 || cardKind == 4 || cardKind == 5) {
            checkAttackCard(cardNum, cardKind, openCard);
            skillBoolean = true;
        }
        if (cardNum == 6) {
            System.out.println("CLOVER[0], HEART[1], DIAMOND[2], SPADE[3] 바꾸고 싶은 모양의 번호를 작성하세요");
            kindNum = scanner.nextInt();
            return sevenBoolean = true;
        }
        // 일반카드일때
        return playNextTurn;
    }

    // 특수카드 발동 할 때 게임 진행 - attackCard = n, 7번
    void skillGameRunning(OneCard submitCard, OneCard openCard) {
        // openCard가 아래의 조건일 때 기준으로 작성
        // A일 때
        // 2일 때
        // 3일 때
        // joker 일 때
        int cardNum = submitCard.number;
        int cardKind = submitCard.kind;

        if (cardNum == 0 || cardNum == 1 || cardNum == 2 || cardKind == 4 || cardKind == 5) {
            // 3번 card 제출이 아닌 이상 true -> 제출할 수 있는 카드는 공격카드 밖에 없기 때문
            skillBoolean = cardNum != 2;
            // filter를 통과하는 card는 checkAttackCard()내부에 포함되는 카드밖에 없어서 공용으로 사용 가능
            checkAttackCard(cardNum, cardKind, openCard);
        }
    }
} // class 끝