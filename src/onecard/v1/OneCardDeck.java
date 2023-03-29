package onecard.v1;

import java.util.Arrays;

class OneCardDeck {
    final int CARD_NUM = 54;
    OneCard[] oneCardArr = new OneCard[CARD_NUM];

    // 카드 덱 생성
    OneCardDeck() {
        int i = 0;
        for (int k = 0; k < OneCard.KIND_MAX; k++) {
            for (int n = 0; n < OneCard.NUM_MAX; n++) {
                oneCardArr[i++] = new OneCard(k, n);
            }
        }
        oneCardArr[52] = new OneCard(4, 13, 1, 2); // 칼라조커
        oneCardArr[53] = new OneCard(5, 14, 0, 3); // 흑백조커
    }


    // 새로 만든 복사본을 이용해서 앞으로 카드 한장씩 받아 갈 것이다.
    OneCard[] changeOneCardArr; // oneCardArr에 배열을 복사해서 넣을 임시 배열

    ////// setting, openSetting, givCard(int i) 하나로 합치는게 가능할 것 같다.
    OneCard[] setting() {
        // 카드를 배열로 주고
        // 해당 array에 카드 제거
        int give7Card = 7;

        // player에게 card 주는 것
        OneCard[] toGivePlayer = Arrays.copyOf(oneCardArr, give7Card);

        // 임시배열 길이 생성
        changeOneCardArr = new OneCard[oneCardArr.length - give7Card];
        // 배열 복사
        System.arraycopy(oneCardArr, give7Card, changeOneCardArr, 0, oneCardArr.length - give7Card);
        // 배열 참조변수와 연결
        oneCardArr = changeOneCardArr;
        return toGivePlayer;
    }

    OneCard openSetting() {
        // 배열 생성 - 복사 - 연결 동일
        OneCard oneCard = oneCardArr[0];
        changeOneCardArr = new OneCard[oneCardArr.length - 1];
        System.arraycopy(oneCardArr, 1, changeOneCardArr, 0, oneCardArr.length - 1);
        oneCardArr = changeOneCardArr;
        return oneCard;
    }

    OneCard[] giveCard(int giveNum) {
        // player에게 card 주는 것
        OneCard[] toGivePlayer = Arrays.copyOf(oneCardArr, giveNum);

        // 임시배열 길이 생성
        changeOneCardArr = new OneCard[oneCardArr.length - giveNum];
        // 배열 복사
        System.arraycopy(oneCardArr, giveNum, changeOneCardArr, 0, oneCardArr.length - giveNum);
        // 배열 참조변수와 연결
        oneCardArr = changeOneCardArr;
        return toGivePlayer;
    }

    void shuffle() {
        for (int i = 0; i < oneCardArr.length; i++) {
            int r = (int) (Math.random() * CARD_NUM);
            OneCard tmp = oneCardArr[i];
            oneCardArr[i] = oneCardArr[r];
            oneCardArr[r] = tmp;
        }
    }

}