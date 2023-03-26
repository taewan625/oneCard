package quiz;

import java.util.Arrays;

public class Quiz3_17 {
    public static void main(String[] args) {
        CardDeck cd = new CardDeck();
        for (int i = 0; i < 52; i++) {
            // 렌덤수를 이용해서 섞자
            int randomNum = (int)(Math.random()*52);
            Card tmp;
            tmp = cd.type[i];
            cd.type[i] = cd.type[randomNum];
            cd.type[randomNum] = tmp;
        }
        String s = cd.ranCheck(cd.type);
        System.out.println("s = " + s);

    }
}

class CardDeck{
    private String[] shape ={"heart", "dia","spade","clover"}; //4
    private int[] num ={1,2,3,4,5,6,7,8,9,10,11,12,13}; //13

    final Card[] type = new Card[53]; // 여기에 card 객체 종류별로 담김
    int typeNum =0;
    CardDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                type[typeNum++] = new Card(shape[i], num[j]);
            }
        }
    }
    String ranCheck(Card[] cards){
        // 객체 필드 자료형 배열로 분리
        String[] shape = new String[5];
        int[] num = new int[5];

        for (int i = 0; i < 5; i++) {
            shape[i] = cards[i].shape;
            num[i] = cards[i].num;
        }

        int[] countNum = new int[14]; // 동일 숫자 개수 세는 것 저장하는 배열
        // countNum에 동일 숫자 개수 넣기
        for (int i = 0; i < num.length; i++) {
            countNum[cards[i].num]++;
        }

        // 5 숫자 연속
        int continueNum = 0;
        for (int i = 0; i < countNum.length-1; i++) {
            if (countNum[i]>0){
                continueNum++;
                if (countNum[i]!=countNum[i+1]) break;
            }
        }

        int sameShape = 0;
        for (int i = 0; i < shape.length-1; i++) {
            if (shape[i].equals(shape[i+1])) sameShape++;
        }

        // 해당 조건
        if (continueNum==5 && sameShape==4) return "Straight and flash";
        if (continueNum==5) return "Straight";
        if (sameShape==4) return "flash";



        // 배열로 동일 숫자 개수 세기
        int twoPair = 0; // 동일 숫자가 2일 때 경우의 수가 2개


        // countNum 배열 index마다 동일 숫자 확인 후 return하기
        for (int i = 1; i < countNum.length; i++) {
            if (countNum[i]==4) return "four card";
            if (countNum[i]==3) return "three card";
            if (countNum[i]==2) twoPair++;
        }

        if (twoPair==2) return "two pair";
        if (twoPair==1) return "one pair";

        return "no rank";
    }
}

class Card{
    String shape;
    int num;
    Card(String shape, int num){
        this.shape=shape;
        this.num=num;
    }
}