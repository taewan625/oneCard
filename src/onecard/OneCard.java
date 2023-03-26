package onecard;

import java.util.Objects;
import java.util.Scanner;

class OneCard {
    static final int KIND_MAX = 4;
    static final int NUM_MAX = 13;

    static final int SPADE = 4;
    static final int DIAMOND = 3;
    static final int HEART = 2;
    static final int CLOVER = 1;
    static final int COLOR_JOKER = 5;
    static final int DARK_JOKER = 6;


    int kind;
    int number;
    int kind1 = -2;
    int kind2 = -2;

    // 카드를 낼때 항상 발동하도록
    int oneCardSkillAttack() {
        if (number == 0) { //A
            System.out.println("공격 카드 입니다. 다음 턴의 사람에게 3장을 먹입니다.");
            return 3;
        }
        if (number == 13) { //color joker
            System.out.println("공격 카드 입니다. 다음 턴의 사람에게 7장을 먹입니다.");
            return 7;
        }
        if (number == 14) { //dark joker
            System.out.println("공격 카드 입니다. 다음 턴의 사람에게 5장을 먹입니다.");
            return 5;
        }
        return 0;
    }

    int oneCardSkillKindChange(Scanner scanner) {
        if (number == 6) { // 7
            System.out.println("변경 카드 입니다. 원하는 모양으로 변경이 가능합니다.");
            int selectKind;
            while (true) {
                System.out.println("CLOVER = 0 , HEART = 1 , DIAMOND = 2 , SPADE = 3 입니다.");
                System.out.println("변경하고 싶은 모양의 번호를 1가지만 입력하세요.");
                // 내가 원하는 kind로 변경
                selectKind = scanner.nextInt();
                if (!(0 <= selectKind && selectKind <= 3)) {
                    System.out.println("번호를 다시 쓰세요");
                    continue;
                }
                return selectKind;
            }
        }
        return -1;
    }

    int oneCardSkillOrder(int growingNum) {
        if (number == 10) { // J
            System.out.println("스킬 발동 중 growingNum = " + growingNum);
            System.out.println("점프 카드 입니다. 다다음 턴의 사람부터 게임을 시작합니다.");
            return growingNum + 1;

        }
        if (number == 12) { // K
            System.out.println("스킬 발동 중 growingNum = " + growingNum);
            System.out.println("한번더 카드 입니다. 카드를 한번더 제출 가능합니다.");
            return growingNum - 1;
        }
        return growingNum;
    }

    public OneCard(int kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    public OneCard(int kind, int number, int kind1, int kind2) {
        this.kind = kind;
        this.number = number;
        this.kind1 = kind1;
        this.kind2 = kind2;
    }

    @Override
    public String toString() {
        String[] kinds = {"CLOVER", "HEART", "DIAMOND", "SPADE", "COLOR_JOKER", "DARK_COLOR"};
        String numbers = "A23456789XJQKSS";
        return kinds[this.kind] + "-" + numbers.charAt(this.number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OneCard) {
            OneCard oneCard = (OneCard) obj;
            if (oneCard.number == this.number && oneCard.kind == this.kind) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kind, number);
    }
}
