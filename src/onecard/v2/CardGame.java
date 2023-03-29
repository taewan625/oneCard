//package onecard.v2;
//
//import java.util.Scanner;
//
//public class CardGame {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("\n원카드 규칙");
//        System.out.println("\n1.카드가 15장 보다 크면 게임이 종료됩니다 \n2. 카드가 아예 없어지면 승리합니다 \n3. 원카드 때 원카드를 외치지 않으면 카드 한장을 먹습니다");
//        System.out.println("\n능력 카드");
//        System.out.println("\nA: 공격 \n7: 카드 모양 변경\nJ: 상대방 1명의 점프 \nQ: 순서변경 \nK: 한번 더 ");
//        System.out.println("주의: 10번 카드는 X로 나타납니다");
//        System.out.println();
//
//
//        // 원카드 deck 생성
//        OneCardDeck oneCardDeck = new OneCardDeck();
//        oneCardDeck.shuffle();
//
//        System.out.println("원카드 덱 섞는 중...");
//        System.out.println("원카드 덱 섞는 중...");
//        System.out.println("원카드 덱 섞는 중...");
//        System.out.println("원카드 덱 섞기 완료");
//        System.out.println();
//
//
//        int playerNum;
//        // player 배열 생성
//        Player[] players;
//        do {
//            System.out.println("플레이어수를 정하세요. 최소 2명에서 최대 4명까지 가능합니다.");
//            System.out.println("인원 수 작성 > ");
//            playerNum = scanner.nextInt();
//
//            if (2 <= playerNum && playerNum <= 4) {
//                players = new Player[playerNum];
//                break;
//            }
//            System.out.println("인원수를 다시 작성하세요");
//        } while (true);
//
//
//
//
//        // Player 에게 카드 나눠 주기
//
//        System.out.println("카드 나눠주는 중...");
//        System.out.println("카드 나눠주는 중...");
//        System.out.println("카드 나눠주는 중...");
//        System.out.println("카드 나눠주는 중...");
//
//        // 원카드 덱으로 부터 플레이어에게 7장씩 나눠주는 것
//        for (int i = 0; i < players.length; i++) {
//            players[i] = new Player(oneCardDeck.setting());
//        }
//
//
//
//
//        // player 카드보여주기
//        System.out.println("각 플레이어의 카드를 보여드립니다.");
//        for (int i = 0; i < players.length; i++) {
//            System.out.print("player"+(i+1)+" : ");
//            System.out.println(players[i]);
//        }
//        System.out.println();
//
//
//        // 원카드 덱의 버려진 카드를 보관하는 오픈원카드 객체 생성 앞으로 여기서 제출한 최근 카드가 보일 것임
//        System.out.println("원카드 셋팅이 완료되었습니다. \n아래 보이는 카드가 시작 카드입니다.");
//        OpenOneCard openOneCard = new OpenOneCard(oneCardDeck.openSetting());
//
//        //////////////////////////////////////// 게임 시작 ////////////////////////////////////////
//        //////////////////////////////////////// 게임 시작 ////////////////////////////////////////
//        //////////////////////////////////////// 게임 시작 ////////////////////////////////////////
//        //////////////////////////////////////// 게임 시작 ////////////////////////////////////////
//
//        // 플레이어 순서 위한 필드값
//        int growingNum = 0;
//        // 몇번 플레이어 인지 배열로 나타냄
//        int[] playerNumber = new int[playerNum];
//        for (int i = 0; i < playerNum; i++) {
//            playerNumber[i] = i + 1;
//        }
//
//        // 공격을 위함 필드값
//        int attackCard = 0;
//
//        // 7번
//        boolean kindChange = false;
//        int selectKind = -1;
//        int orders;
/////////////////////////////////////////////////while문 시작/////////////////////////////////////////////////////////////
//        while (true){
//            orders = growingNum % playerNum;
//            growingNum++;
//            OneCard submitCard;
//            int submitCardIndex;
//
//            OneCard openOneCardFirstOne = openOneCard.openOneCardArr[0];
//            System.out.println();
//            if (!kindChange) {
//                System.out.println("해당 카드를 보고 같은 모양 혹은 숫자를 제출하세요 : " + openOneCardFirstOne);
//            } else {
//                String[] kinds = {"CLOVER", "HEART", "DIAMOND", "SPADE"};
//                System.out.println("해당 카드와 동일한 모양을 제출하세요 : " + kinds[selectKind]);
//            }
//
//            // 내부 while문 - 각 플레이어 턴이 완벽히 종료되면 해당 while문을 벗어날 수 있다.
//            do {
//                // 공격카드가 존재시 해당턴에 카드 먹고 다음 사람 턴으로 넘어감
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
//
//
//                // 제출한 카드가 아래의 조건이 아닐 때 내부 do-while문 continue 돌림
//                if (!(0 <= submitCardIndex && submitCardIndex < players[orders].playerOneCardArr.length)) {
//                    System.out.println("주어진 범위 내의 숫자를 작성하세요");
//                    continue;
//                }
//
//                // 선택한 player 카드 객체
//                submitCard = players[orders].playerOneCardArr[submitCardIndex];
//
//                // 7번 카드로 모양이 변경되었을 때의 다음으로 넘어갈 수 있는 조건문
//                if (kindChange==true) {
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
//                        }else {
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
//
//                if (kindChange == false) {
//
//                    // open 카드와 조건이 맞을 때만 다음으로 넘어갈수 있도록
//                    if (submitCard.kind == openOneCardFirstOne.kind
//                            || submitCard.kind == openOneCardFirstOne.kind1
//                            || submitCard.kind == openOneCardFirstOne.kind2
//                            || submitCard.number == openOneCardFirstOne.number
//                            || submitCard.kind1 == openOneCardFirstOne.kind
//                            || submitCard.kind2 == openOneCardFirstOne.kind
//                    ) {
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
//                        break;
//                    }
//                }
//                System.out.println("규칙에 맞는 카드번호를 제출하세요");
//            } while (true); // do-while문 끝
//
//            // 카드 15 이상인 사람 존재시 그사람 제거, 그리고 남은 사람 1명이면 그사람 우승, 아니면 계속 진행
//            // open pack에 카드 8장 이하면 onecard deck에 넣기
//
//            // 자신이 0이면 turn 종료
//            if (players[orders].playerOneCardArr.length == 0) {
//                System.out.println("우승자는 " + playerNumber[orders] + " player 입니다.");
//                System.exit(0);
//            }
//
//
//
//        } /////////////////////////////// while문 끝 ///////////////////////////////////////////
//    } // main 끝
//} // class 끝
//
//
