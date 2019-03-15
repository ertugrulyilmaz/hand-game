package com.ta.game;

import com.ta.game.entity.Hand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestHand {

  @Test
  public void test() {
    final Hand hand01 = Hand.fromString("TS JS QS KS AS");
    final Hand hand02 = Hand.fromString("5S 6S 7S 8S 9S");
    final Hand hand03 = Hand.fromString("7S TC TH TS TD");
    final Hand hand04 = Hand.fromString("5H 5C QD QC QS");
    final Hand hand05 = Hand.fromString("2D 3D 7D QD AD");
    final Hand hand06 = Hand.fromString("4D 5D 6D 7H 8D");
    final Hand hand07 = Hand.fromString("4D 4H 4S 7H 8D");
    final Hand hand08 = Hand.fromString("4D 4H 7S 7H QD");
    final Hand hand09 = Hand.fromString("4D 4H 7S QH AD");
    final Hand hand10 = Hand.fromString("2D 4C 6D 7H AD");

    assertEquals("<hand [TS JS QS KS AS], 'Royal Flush'>", hand01.toString());
    assertEquals("<hand [5S 6S 7S 8S 9S], 'Straight Flush'>", hand02.toString());
    assertEquals("<hand [7S TC TH TS TD], 'Four of a Kind'>", hand03.toString());
    assertEquals("<hand [5H 5C QD QC QS], 'Full House'>", hand04.toString());
    assertEquals("<hand [2D 3D 7D QD AD], 'Flush'>", hand05.toString());
    assertEquals("<hand [4D 5D 6D 7H 8D], 'Straight'>", hand06.toString());
    assertEquals("<hand [4D 4H 4S 7H 8D], 'Three of a Kind'>", hand07.toString());
    assertEquals("<hand [4D 4H 7S 7H QD], 'Two Pair'>", hand08.toString());
    assertEquals("<hand [4D 4H 7S QH AD], 'One Pair'>", hand09.toString());
    assertEquals("<hand [2D 4C 6D 7H AD], 'High Card'>", hand10.toString());
  }

  @Test
  public void shouldThrowExceptionWhenStringIsNullOrEmpty() {
    assertThrows(IllegalArgumentException.class, () -> Hand.fromString(null));
    assertThrows(IllegalArgumentException.class, () -> Hand.fromString(""));
  }

  @Test
  public void shouldThrowExceptionWhenCardCountIsNotValid() {
    assertThrows(IllegalArgumentException.class, () -> Hand.fromString("AS"));
    assertThrows(IllegalArgumentException.class, () -> Hand.fromString("AS AH"));
    assertThrows(IllegalArgumentException.class, () -> Hand.fromString("AS AH AD"));
    assertThrows(IllegalArgumentException.class, () -> Hand.fromString("AS AH AD AC"));
  }

}
