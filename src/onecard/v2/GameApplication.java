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
        Dealer dealer = new Dealer();
        CardGame cardGame = new CardGame();
        OpenDeck openDeck = new OpenDeck();

        // dealer - oneCardDeck shuffle, openDeck 1장 깔기
        dealer.shuffleOneCardDeck();
        dealer.giveCard(openDeck, 1);


        // 필드
        int submitCardIndex;
        OneCard submitCard;
        OneCard openCard = openDeck.getOpenCard();
        boolean playerNextTurn = true;

        Player currentPlayer;

        while (true) {
            System.out.println("플레이어수를 정하세요. 최소 2명에서 최대 7명까지 가능합니다.");
            System.out.println("인원 수 작성 > ");
            // 한번만 쓰고 버릴 변수는 lv로 작성
            int playerNum = scanner.nextInt();

            // player 수에 맞게 player 생성, player 수에 따른 카드 배분
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
        MyLinkedList playerLinkedList = cardGame.playerLinkedList;
        cardGame.nextTurn(playerNextTurn);

        while (true) {
            System.out.println("developMode");
            cardGame.playerLinkedList.print();
            System.out.println("oneCardDeck:" + dealer.oneCardDeck.oneCardList.size());
            System.out.println("openDeck: " + openDeck.openDeckList);
            System.out.println("developModeFinish");

            // 원카드 덱의 버려진 카드를 보관하는 오픈원카드 객체 생성 앞으로 여기서 제출한 최근 카드가 보일 것임
            System.out.println(" 오픈 카드 : " + openDeck);


            // 현재 player와 playerDeck 보여줌
            currentPlayer = (Player) playerLinkedList.getCurrent().data;
            System.out.println(currentPlayer.getPlayerNum() + " player 차례입니다. \n" + currentPlayer);
            System.out.println("제출할 카드의 위치에 맞는 번호를 넣으세요. (작성 예 : 첫번째 카드 부터 0,1,2,3)");
            System.out.println("제출할 수 있는 카드가 존재하지 않는다면 -1을 작성하세요. 카드를 한장 받고 턴을 종료합니다.");

            // scanner 제출할 카드
            submitCardIndex = scanner.nextInt();
            submitCard = (0 <= submitCardIndex && submitCardIndex < currentPlayer.playerDeck.size()) ? currentPlayer.playerDeck.get(submitCardIndex) : null;

            // 1. 제출 카드 없을 때 // 제출한 카드가 아래의 조건이 아닐 때 continue -> 이걸 CardGame class에 넣자
            if (submitCardIndex == -1) {
                System.out.println("제출할 카드가 없어서 카드 한 장 가져옵니다.");
                dealer.giveCard(currentPlayer, 1);
            } else if (!(0 <= submitCardIndex && submitCardIndex < currentPlayer.playerDeck.size())) {
                System.out.println("주어진 범위 내의 숫자를 작성하세요");
                continue;
            } else if(!(submitCard.kind == openCard.kind || submitCard.number == openCard.number)) {
                // joker 일 때 예외를 두기 - method(턴 종료 후 남은 카드 보여주기, 원카드 부족시 추가코드) 넣기
                System.out.println("올바르지 않은 카드입니다. 다시 제출하세요");
                continue;
            } else {
                dealer.getCard(openDeck, currentPlayer, currentPlayer.playerDeck.get(submitCardIndex));
                //
            }

            // 3. 턴종료 후 남은 카드 보여주기
            System.out.println(currentPlayer.getPlayerNum() + " player 턴이 종료됩니다. \n" + currentPlayer);

            // OneCardDeck에 card 부족시 추가하는 코드
            if (dealer.oneCardDeck.oneCardList.size() < 8) {
                System.out.println(dealer.oneCardDeck.oneCardList);
                dealer.resetCard(openDeck);
            }

            // 다음 턴
            cardGame.nextTurn(playerNextTurn);
        }
//        } (true){
//
//
//        }
//
//
//
//        if (submitCard.kind == openOneCardFirstOne.kind
//                || submitCard.kind == openOneCardFirstOne.kind1
//                || submitCard.kind == openOneCardFirstOne.kind2
//                || submitCard.number == openOneCardFirstOne.number
//                || submitCard.kind1 == openOneCardFirstOne.kind
//                || submitCard.kind2 == openOneCardFirstOne.kind
//        ) {
//
//            // 카드 스킬 발동
//            // 공격 스킬
//            attackCard = submitCard.oneCardSkillAttack();
//
//            // 종류 변경 스킬
//            selectKind = submitCard.oneCardSkillKindChange(scanner);
//            if (selectKind >= 0) {
//                kindChange = true;
//            } else {
//                kindChange = false;
//            }
//
//            // 순서 변경 스킬
//            growingNum = submitCard.oneCardSkillOrder(growingNum);
//
//            // 순서 변경 스킬
//            if (submitCard.number == 11 && players.length > 2) {
//                System.out.println("순서변경 카드 입니다. 역순으로 순서가 변경되었습니다");
//                Player tmp;
//                // q를 시전한 player 다음 플레이어 와 q를 시전한 player 이전 플레이어의 자리 바꿈
//                tmp = players[growingNum % playerNum];
//                players[growingNum % playerNum] = players[(growingNum - 2) % playerNum];
//                players[(growingNum - 2) % playerNum] = tmp;
//
//                // player 번호도 변경해줌
//                int tmp1;
//                tmp1 = playerNumber[growingNum % playerNum];
//                playerNumber[growingNum % playerNum] = playerNumber[(growingNum - 2) % playerNum];
//                playerNumber[(growingNum - 2) % playerNum] = tmp1;
//            }
//
//            // open 카드에 카드 추가
//            openOneCard.getCard(submitCard);
//
//            // 개인 카드 제거
//            players[orders].trashCard(submitCardIndex);
//
//            System.out.println("카드 제출에 성공했습니다. 턴을 종료합니다.");
//            break;
//        }



//        while (true) {
//
//            OneCard openOneCardFirstOne = openOneCard.openOneCardArr[0];
//            System.out.println();
//            if (!kindChange) {
//                System.out.println("해당 카드를 보고 같은 모양 혹은 숫자를 제출하세요 : " + openOneCardFirstOne);
//            } else {
//                String[] kinds = {"CLOVER", "HEART", "DIAMOND", "SPADE"};
//                System.out.println("해당 카드와 동일한 모양을 제출하세요 : " + kinds[selectKind]);
//            }
//        }

            // 내부 while문 - 각 플레이어 턴이 완벽히 종료되면 해당 while문을 벗어날 수 있다.
/**
/////////////////// 공격카드가 존재시 해당턴에 카드 먹고 다음 사람 턴으로 넘어감
//                if (attackCard != 0) {
//                    System.out.println((playerNumber[orders]) + " 번 플레이어 차레입니다.");
//                    System.out.println("보유 카드 : " + players[orders]);
//                    System.out.println("직전의 공격 카드로 인해서 원카드 덱에서 카들를 먹고 턴을 종료합니다.");
//                    // 원카드 덱 n장 없애기
//                    OneCard[] giveCardsArr = oneCardDeck.giveCard(attackCard);
//                    // 원카드 덱으로 부터 n장 받아오기
//                    players[orders].getCard(giveCardsArr);
//                    attackCard = 0;
//                    break;
//                }
//
//                // 몇번 플레이어 차례인지, 터미널에서 번호를 통해 제출 할수 있도록 알려줌
//                System.out.println(playerNumber[orders] + " 번 플레이어 차레입니다.");
//                System.out.println("보유 카드 : " + players[orders]);
//                System.out.println("제출할 카드의 위치에 맞는 번호를 넣으세요. 작성 예 : 첫번째 카드 부터 0,1,2,3");
//                System.out.println("제출할 수 있는 카드가 존재하지 않는다면 -1을 작성하세요. 카드를 한장 받고 턴을 종료합니다.");
//                // 제출한 카드
//                submitCardIndex = scanner.nextInt();
//
//
//                // 제출할 카드가 존재하지 않을 시
//                if (submitCardIndex == -1) {
//                    System.out.println("제출할 카드가 없어서 카드한장을 원카드 덱으로 부터 가져온 후 턴을 종료합니다.");
//                    System.out.println();
//                    System.out.println("카드 한 장을 가져옵니다.");
//                    // 원카드 덱 1장 없애기
//                    OneCard[] giveCardsArr = oneCardDeck.giveCard(1);
//                    // 원카드 덱으로 부터 1장 받아오기
//                    players[orders].getCard(giveCardsArr);
//                    break;
//                }
*/

/////////////////////// 제출한 카드가 아래의 조건이 아닐 때 내부 do-while문 continue 돌림
//                if (!(0 <= submitCardIndex && submitCardIndex < players[orders].playerOneCardArr.length)) {
//                    System.out.println("주어진 범위 내의 숫자를 작성하세요");
//                    continue;
//                }
//
//                // 선택한 player 카드 객체
//                submitCard = players[orders].playerOneCardArr[submitCardIndex];
//
//                // 7번 카드로 모양이 변경되었을 때의 다음으로 넘어갈 수 있는 조건문
//                if (kindChange == true) {
//                    if (submitCard.kind == selectKind
//                            || submitCard.kind1 == selectKind
//                            || submitCard.kind2 == selectKind) {
//
//                        // 카드 스킬 발동
//                        // 공격 스킬
//                        attackCard = submitCard.oneCardSkillAttack();
//
//                        // 종류 변경 스킬
//                        selectKind = submitCard.oneCardSkillKindChange(scanner);
//                        if (selectKind >= 0) {
//                            kindChange = true;
//                        } else {
//                            kindChange = false;
//                        }
//
//                        // 순서 변경 스킬
//                        growingNum = submitCard.oneCardSkillOrder(growingNum);
//
//                        // 순서 변경 스킬
//                        if (submitCard.number == 11 && players.length > 2) {
//                            System.out.println("순서변경 카드 입니다. 역순으로 순서가 변경되었습니다");
//                            Player tmp;
//                            // q를 시전한 player 다음 플레이어 와 q를 시전한 player 이전 플레이어의 자리 바꿈
//                            tmp = players[growingNum % playerNum];
//                            players[growingNum % playerNum] = players[(growingNum - 2) % playerNum];
//                            players[(growingNum - 2) % playerNum] = tmp;
//
//                            // player 번호도 변경해줌
//                            int tmp1;
//                            tmp1 = playerNumber[growingNum % playerNum];
//                            playerNumber[growingNum % playerNum] = playerNumber[(growingNum - 2) % playerNum];
//                            playerNumber[(growingNum - 2) % playerNum] = tmp1;
//                        }
//
//                        // open 카드에 카드 추가
//                        openOneCard.getCard(submitCard);
//
//                        // 개인 카드 제거
//                        players[orders].trashCard(submitCardIndex);
//
//                        System.out.println("카드 제출에 성공했습니다. 턴을 종료합니다.");
//                        System.out.println("do-while문 종료후 growingNum = " + growingNum);
//                        break;
//                    }
//                }


//                System.out.println("규칙에 맞는 카드번호를 제출하세요");

//            // 카드 15 이상인 사람 존재시 그사람 제거, 그리고 남은 사람 1명이면 그사람 우승, 아니면 계속 진행
//            // open pack에 카드 8장 이하면 onecard deck에 넣기
//
//            // 자신이 0이면 turn 종료
//            if (players[orders].playerOneCardArr.length == 0) {
//                System.out.println("우승자는 " + playerNumber[orders] + " player 입니다.");
//                System.exit(0);
//            }

    } // main 끝
}
