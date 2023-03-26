import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Quiz3_17Test {

    public String rankCheck(Card[] cards) {
        CardDeck cardDeck = new CardDeck();
        return cardDeck.ranCheck(cards);
    }

    @Test
    void StraightAndFlash() {
        Card[] cards = {
                new Card("heart", 1),
                new Card("heart", 2),
                new Card("heart", 3),
                new Card("heart", 4),
                new Card("heart", 5),
        };
        assertEquals("Straight and flash", rankCheck(cards));
    }
    @Test
    void Straight() {
        Card[] cards = {
                new Card("heart", 1),
                new Card("heart", 2),
                new Card("heart", 3),
                new Card("heart", 4),
                new Card("clover", 5),
        };
        assertEquals("Straight", rankCheck(cards));
    }
    @Test
    void Flash() {
        Card[] cards = {
                new Card("heart", 1),
                new Card("heart", 1),
                new Card("heart", 2),
                new Card("heart", 2),
                new Card("heart", 2),
        };
        Card[] cards1 = {
                new Card("heart", 1),
                new Card("heart", 2),
                new Card("heart", 3),
                new Card("heart", 4),
                new Card("heart", 4),
        };
        Card[] cards2 = {
                new Card("heart", 5),
                new Card("heart", 4),
                new Card("heart", 3),
                new Card("heart", 2),
                new Card("heart", 2),
        };
        Card[] cards3 = {
                new Card("heart", 1),
                new Card("heart", 2),
                new Card("heart", 3),
                new Card("heart", 2),
                new Card("heart", 1),
        };


        assertEquals("flash", rankCheck(cards));
        assertEquals("flash", rankCheck(cards1));
        assertEquals("flash", rankCheck(cards2));
        assertEquals("flash", rankCheck(cards3));
    }
    @Test
    void four() {
        Card[] cards = {
                new Card("heart", 1),
                new Card("heart", 1),
                new Card("heart", 1),
                new Card("heart", 1),
                new Card("spade", 2),
        };
        Card[] cards1 = {
                new Card("heart", 1),
                new Card("heart", 13),
                new Card("heart", 13),
                new Card("spade", 13),
                new Card("heart", 13),
        };
        Card[] cards2 = {
                new Card("heart", 13),
                new Card("heart", 12),
                new Card("spade", 12),
                new Card("heart", 12),
                new Card("heart", 12),
        };
        Card[] cards3 = {
                new Card("heart", 13),
                new Card("spade", 1),
                new Card("heart", 1),
                new Card("heart", 1),
                new Card("heart", 1),
        };
        Card[] cards4 = {
                new Card("spade", 13),
                new Card("heart", 13),
                new Card("heart", 3),
                new Card("heart", 13),
                new Card("heart", 13),
        };


        assertEquals("four card", rankCheck(cards));
        assertEquals("four card", rankCheck(cards1));
        assertEquals("four card", rankCheck(cards2));
        assertEquals("four card", rankCheck(cards3));
        assertEquals("four card", rankCheck(cards4));
    }
    @Test
    void three() {
        Card[] cards = {
                new Card("heart", 1),
                new Card("heart", 1),
                new Card("heart", 1),
                new Card("heart", 2),
                new Card("spade", 2),
        };
        Card[] cards1 = {
                new Card("heart", 1),
                new Card("heart", 1),
                new Card("heart", 13),
                new Card("spade", 13),
                new Card("heart", 13),
        };
        Card[] cards2 = {
                new Card("heart", 13),
                new Card("heart", 13),
                new Card("spade", 12),
                new Card("heart", 12),
                new Card("heart", 12),
        };
        Card[] cards3 = {
                new Card("heart", 13),
                new Card("spade", 13),
                new Card("heart", 1),
                new Card("heart", 1),
                new Card("heart", 1),
        };
        Card[] cards4 = {
                new Card("spade", 13),
                new Card("heart", 5),
                new Card("heart", 3),
                new Card("heart", 13),
                new Card("heart", 13),
        };


        assertEquals("three card", rankCheck(cards));
        assertEquals("three card", rankCheck(cards1));
        assertEquals("three card", rankCheck(cards2));
        assertEquals("three card", rankCheck(cards3));
        assertEquals("three card", rankCheck(cards4));
    }
    @Test
    void twoPair() {
        Card[] cards = {
                new Card("heart", 1),
                new Card("heart", 1),
                new Card("heart", 13),
                new Card("heart", 2),
                new Card("spade", 2),
        };
        Card[] cards1 = {
                new Card("heart", 1),
                new Card("heart", 1),
                new Card("heart", 13),
                new Card("spade", 13),
                new Card("heart", 6),
        };
        Card[] cards2 = {
                new Card("heart", 13),
                new Card("heart", 13),
                new Card("spade", 1),
                new Card("heart", 12),
                new Card("heart", 12),
        };
        Card[] cards3 = {
                new Card("heart", 13),
                new Card("spade", 13),
                new Card("heart", 7),
                new Card("heart", 3),
                new Card("heart", 3),
        };
        Card[] cards4 = {
                new Card("spade", 11),
                new Card("heart", 5),
                new Card("heart", 5),
                new Card("heart", 11),
                new Card("heart", 13),
        };


        assertEquals("two pair", rankCheck(cards));
        assertEquals("two pair", rankCheck(cards1));
        assertEquals("two pair", rankCheck(cards2));
        assertEquals("two pair", rankCheck(cards3));
        assertEquals("two pair", rankCheck(cards4));
    }

    @Test
    void onePair() {
        Card[] cards = {
                new Card("heart", 1),
                new Card("heart", 1),
                new Card("heart", 13),
                new Card("heart", 3),
                new Card("spade", 2),
        };
        Card[] cards1 = {
                new Card("heart", 1),
                new Card("heart", 5),
                new Card("heart", 13),
                new Card("spade", 13),
                new Card("heart", 6),
        };
        Card[] cards2 = {
                new Card("heart", 13),
                new Card("heart", 12),
                new Card("spade", 11),
                new Card("heart", 10),
                new Card("heart", 10),
        };
        Card[] cards3 = {
                new Card("heart", 13),
                new Card("spade", 13),
                new Card("heart", 1),
                new Card("heart", 2),
                new Card("heart", 3),
        };
        Card[] cards4 = {
                new Card("spade", 10),
                new Card("heart", 9),
                new Card("heart", 9),
                new Card("heart", 8),
                new Card("heart", 7),
        };


        assertEquals("one pair", rankCheck(cards));
        assertEquals("one pair", rankCheck(cards1));
        assertEquals("one pair", rankCheck(cards2));
        assertEquals("one pair", rankCheck(cards3));
        assertEquals("one pair", rankCheck(cards4));
    }
    @Test
    void noRank() {
        Card[] cards = {
                new Card("heart", 1),
                new Card("heart", 2),
                new Card("heart", 3),
                new Card("heart", 4),
                new Card("spade", 13),
        };
        Card[] cards1 = {
                new Card("heart", 1),
                new Card("heart", 2),
                new Card("heart", 3),
                new Card("spade", 4),
                new Card("heart", 6),
        };
        Card[] cards2 = {
                new Card("heart", 13),
                new Card("heart", 12),
                new Card("spade", 11),
                new Card("heart", 7),
                new Card("heart", 10),
        };
        Card[] cards3 = {
                new Card("heart", 2),
                new Card("spade", 3),
                new Card("heart", 5),
                new Card("heart", 6),
                new Card("heart", 8),
        };
        Card[] cards4 = {
                new Card("spade", 10),
                new Card("heart", 9),
                new Card("heart", 3),
                new Card("heart", 8),
                new Card("heart", 7),
        };


        assertEquals("no rank", rankCheck(cards));
        assertEquals("no rank", rankCheck(cards1));
        assertEquals("no rank", rankCheck(cards2));
        assertEquals("no rank", rankCheck(cards3));
        assertEquals("no rank", rankCheck(cards4));
    }

}