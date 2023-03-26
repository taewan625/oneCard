package onecard;

class OpenOneCard {
    OneCard[] openOneCardArr = new OneCard[1];
    OneCard[] changeOneCardArr;

    public OpenOneCard(OneCard oneCardFromOneCardDeck) {
        openOneCardArr[0] = oneCardFromOneCardDeck;
    }

    void getCard(OneCard oneCard) {
        // 배열 생성 - getCard는 한장씩만 받으니깐 +1 만 하기
        changeOneCardArr = new OneCard[openOneCardArr.length + 1];
        // 배열 복사 - 원래 카드는 두번째 칸부터 복사
        System.arraycopy(openOneCardArr, 0, changeOneCardArr, 1, openOneCardArr.length);
        // 배열 연결
        openOneCardArr = changeOneCardArr;
        // 배열 첫칸에 params로 받은 원카드 객체 추가
        openOneCardArr[0] = oneCard;
    }

}
