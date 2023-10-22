package onecard.v2;

import java.util.Scanner;

public class GameApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("원카드 규칙");
        System.out.println("1.카드가 15장 보다 크면 탈락입니다. \n2. 카드가 아예 없어지면 승리합니다 \n3. 원카드 때 원카드를 외치지 않으면 카드 한장을 먹습니다");
        System.out.println("skill 카드 \n공격카드 - A:3장 2:2장 흑조커:5장 색조커:7장 \n방어카드 - 직전 공격카드와 동일한 무늬인 3 제출시 공격 무력화, 조커 : A,2의 공격을 다음 턴의 사람한테 공격 중첩" +
                "\n무늬변경카드 - 7 \n순서변경카드 - J: 상대방 1명의 점프 Q: 순서변경 K: 한번 더 ");
        System.out.println("참고: 10번 카드는 X로 나타납니다");


        // class 객체 생성
        Dealer dealer = new Dealer(); // 내부 - OneCardDeck 생성
        CardGame cardGame = new CardGame(); // 내부 - MyLinkedList, OneCardSkill class 생성
        OpenDeck openDeck = new OpenDeck();

        // dealer - oneCardDeck shuffle, openDeck 1장 깔기
        dealer.shuffleOneCardDeck();
        dealer.giveCard(openDeck, 1);


        // 필드
        int submitCardIndex;
        OneCard submitCard;
        OneCard openCard;
        boolean playerNextTurn = true; // v3. Card.game에 넣기
        boolean filterSubmittedCard;

        Player currentPlayer; // v3. Player 내부에 넣기

        while (true) {
            System.out.println("플레이어수를 정하세요. 최소 2명에서 최대 7명까지 가능합니다.");
            System.out.println("인원 수 작성 > ");
            // 한번만 쓰고 버릴 변수는 lv로 작성
            int playerNum = scanner.nextInt();

            // player 수에 맞게 player 생성, player 수에 따른 카드 배분 v3. player 번호 직접 값 넣
            if (2 <= playerNum && playerNum <= 7) {
                cardGame.playerList(playerNum);
                    for (int i = 0; i < playerNum; i++) {
                        // player에게 카드주기
                        Player player = cardGame.getPlayer(i);
                        int cardNum = playerNum < 5 ? 7 : 5;
                        dealer.giveCard(player, cardNum);
                    }
                    break;
            }
            System.out.println("인원수를 다시 작성하세요");
        }


        // 순서 회전
        // boolean - nextTurn() 만듬
        MyLinkedList playerLinkedList = cardGame.playerLinkedList; //v3 MyLinkedList field 값으로 올리기
        cardGame.nextTurn(playerNextTurn);

        while (true) {
           /* System.out.println("----------------developMode------------------");
            cardGame.playerLinkedList.print();
            System.out.println("oneCardDeck:" + dealer.oneCardDeck.oneCardList.size());
            System.out.println("openDeck: " + openDeck.openDeckList);
            System.out.println("cardGame.attackCards = " + cardGame.attackCards);
            System.out.println("cardGame.kindNum = " + cardGame.kindNum);
            System.out.println("cardGame.kindBoolean = " + cardGame.skillBoolean);
            System.out.println("-----------developModeFinish-------------------");*/

            // 원카드 덱의 버려진 카드를 보관하는 오픈원카드 객체 생성 앞으로 여기서 제출한 최근 카드가 보일 것임
            System.out.println(" 오픈 카드 : " + openDeck);
            openCard = openDeck.getOpenCard();

            // 현재 player와 playerDeck 보여줌
            currentPlayer = (Player) playerLinkedList.getCurrent().data;
            System.out.println(currentPlayer.getPlayerNum() + " player 차례입니다. \n" + currentPlayer);
            System.out.println("제출할 카드의 위치에 맞는 번호를 넣으세요. (작성 예 : 첫번째 카드 부터 0,1,2,3)");
            System.out.println("제출할 수 있는 카드가 존재하지 않는다면 -1을 작성하세요. 카드를 한장 받고 턴을 종료합니다.");

            // scanner 제출할 카드와 제출할 카드 index
            submitCardIndex = scanner.nextInt();
            submitCard = (0 <= submitCardIndex && submitCardIndex < currentPlayer.playerDeck.size())
                    ? currentPlayer.playerDeck.get(submitCardIndex) : null;


            // 범위에 벗어난 수, 올바르지 않는 제출 카드 일때 continue
            filterSubmittedCard = (!cardGame.skillBoolean)
                    ? cardGame.submittedCardFilter(submitCardIndex, submitCard, openCard, currentPlayer, dealer)
                    : cardGame.skillSubmittedCardFilter(submitCardIndex, submitCard, openCard, currentPlayer, dealer);

            if (filterSubmittedCard) {
                continue;
            }

            // 특수카드 발동 안할 때 if문, 특수카드 발동 할 때 else-if문 실행 - attackCard 아닌 경우만
            if (submitCardIndex >= 0 && !cardGame.skillBoolean) {
                // 제출한 카드 중 특수카드가 포함될 때 특수카드 능력 수행 후 종료
                playerNextTurn = cardGame.gameRunning(submitCard, cardGame, playerNextTurn, openCard);
                // 모든 카드 공통 작업 - 자기카드 제출
                dealer.getCard(openDeck, currentPlayer, submitCard);
            } else if(submitCardIndex >= 0) {
                // 제출한 카드 중 특수카드가 포함될 때 특수카드 능력 수행 후 종료
                cardGame.skillGameRunning(submitCard, openCard);
                dealer.getCard(openDeck, currentPlayer, submitCard);
            }

            // 3. 턴종료 후 남은 카드 보여주기
            System.out.println(currentPlayer.getPlayerNum() + " player 턴이 종료됩니다. \n" + currentPlayer);

            // OneCardDeck에 card 부족시 추가하는 코드
            if (dealer.oneCardDeck.oneCardList.size() < 8) {
                dealer.resetCard(openDeck);
            }

            // 자신이 0이면 turn 종료
            if (currentPlayer.playerDeck.size() == 0) {
                System.out.println("우승자는 " + currentPlayer.getPlayerNum() + " player 입니다.");
                System.exit(0);
            }

            // player 중 15장 이상이면 myLinkedList에서 제거하고 가지고 있는 카드 oneCard deck에 넣어주기
            // 1. oneCard deck에 넣는 method() 생성
            // 2. myLinkedList remove(); 이용

            // 다음 턴
            cardGame.nextTurn(playerNextTurn);
        }

    } // main 끝
}
