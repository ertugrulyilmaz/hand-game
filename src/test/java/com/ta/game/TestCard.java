package com.ta.game;

import com.ta.game.entity.Card;
import com.ta.game.entity.enums.Suit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCard {

  @Test
  public void shouldThrowExceptionWhenCardCreatingWithNullValue() {
    assertThrows(IllegalArgumentException.class, () -> Card.of(null));
  }

  @Test
  public void shouldThrowExceptionWhenCardCreatingWithEmptyValue() {
    assertThrows(IllegalArgumentException.class, () -> Card.of(""));
  }

  @Test
  public void shouldThrowExceptionIfCardLengthWrong1() {
    assertThrows(IllegalArgumentException.class, () -> Card.of("A"));
  }

  @Test
  public void shouldThrowExceptionIfCardLengthWrong2() {
    assertThrows(IllegalArgumentException.class, () -> Card.of("ACB"));
  }

  @Test
  public void shouldThrowExceptionIfCardTypeIsNotValid() {
    assertThrows(IllegalArgumentException.class, () -> Card.of("0A"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("1A"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("BD"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("CD"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("DD"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("ED"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("FD"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("GD"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("HD"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("ID"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("ID"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("LD"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("MD"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("ND"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("OD"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("PD"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("RD"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("SD"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("UD"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("WD"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("YD"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("XD"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("ZD"));
  }

  @Test
  public void shouldThrowExceptionIfSuitTypeIsNotValid() {
    assertThrows(IllegalArgumentException.class, () -> Card.of("2A"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2B"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2E"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2F"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2G"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2I"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2J"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2K"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2L"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2M"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2N"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2Q"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2O"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2P"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2R"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2T"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2U"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2W"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2V"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2Y"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2X"));
    assertThrows(IllegalArgumentException.class, () -> Card.of("2Z"));
  }

  @Test
  public void checkValidCard() {
    assertDoesNotThrow(() -> Card.of("AC"));
    assertDoesNotThrow(() -> Card.of("2D"));
    assertDoesNotThrow(() -> Card.of("3H"));
    assertDoesNotThrow(() -> Card.of("TS"));

    final Card card1 = Card.of("AC");
    final Card card2 = Card.of("AD");
    final Card card3 = Card.of("AH");
    final Card card4 = Card.of("AS");

    assertEquals(14, card1.getIndex());
    assertEquals('A', card1.getCard());
    assertEquals("Ace", card1.getLabel());
    Assertions.assertEquals(Suit.C, card1.getSuit());
    Assertions.assertEquals(Suit.D, card2.getSuit());
    Assertions.assertEquals(Suit.H, card3.getSuit());
    Assertions.assertEquals(Suit.S, card4.getSuit());
  }

}
