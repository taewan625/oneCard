package onecard.v2;

import java.util.Objects;
import java.util.Scanner;

class OneCard {
    static final int KIND_MAX = 4;
    static final int NUM_MAX = 13;

    int kind;
    int number;


    public OneCard(int kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    @Override
    public String toString() {
        String[] kinds = {"CLOVER", "HEART", "DIAMOND", "SPADE", "COLOR_JOKER", "DARK_JOKER"};
        //                    0        1          2        3          4              5
        String numbers = "A23456789XJQKS";
        return kinds[this.kind] + "-" + numbers.charAt(this.number);
    }

    // color_joker와 dark joker 한해서 equals 범위 늘려주기
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
