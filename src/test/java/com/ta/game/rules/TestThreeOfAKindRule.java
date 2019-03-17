package com.ta.game.rules;

import com.google.common.collect.Lists;
import com.ta.game.entity.Card;
import com.ta.game.rule.ThreeOfAKind;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestThreeOfAKindRule {

  @Test
  public void testThreeOfAKindRule() {
    final List<Card> cards1 = Lists.newArrayList(Card.of("2S"), Card.of("2H"), Card.of("2D"), Card.of("3H"), Card.of("AC"));
    final List<Card> cards2 = Lists.newArrayList(Card.of("3S"), Card.of("4S"), Card.of("4D"), Card.of("4H"), Card.of("AC"));
    final List<Card> cards3 = Lists.newArrayList(Card.of("3H"), Card.of("7S"), Card.of("7D"), Card.of("7H"), Card.of("8C"));
    final List<Card> cards4 = Lists.newArrayList(Card.of("2H"), Card.of("2S"), Card.of("3D"), Card.of("3H"), Card.of("8C"));
    final List<Card> cards5 = Lists.newArrayList(Card.of("2H"), Card.of("4S"), Card.of("5D"), Card.of("8H"), Card.of("8C"));

    final ThreeOfAKind threeOfAKind = new ThreeOfAKind();

    assertTrue(threeOfAKind.check(cards1));
    assertTrue(threeOfAKind.check(cards2));
    assertTrue(threeOfAKind.check(cards3));
    assertFalse(threeOfAKind.check(cards4));
    assertFalse(threeOfAKind.check(cards5));
  }

  @Test
  public void testComparisionOfTwoHand() {
    final List<Card> cards1 = Lists.newArrayList(Card.of("2S"), Card.of("2H"), Card.of("2D"), Card.of("3H"), Card.of("AC"));
    final List<Card> cards2 = Lists.newArrayList(Card.of("3H"), Card.of("7S"), Card.of("7D"), Card.of("7H"), Card.of("8C"));
    final List<Card> cards3 = Lists.newArrayList(Card.of("3S"), Card.of("4S"), Card.of("4D"), Card.of("4H"), Card.of("AC"));
    final List<Card> cards4 = Lists.newArrayList(Card.of("2S"), Card.of("4S"), Card.of("4D"), Card.of("4H"), Card.of("AC"));
    final List<Card> cards5 = Lists.newArrayList(Card.of("2H"), Card.of("4S"), Card.of("4D"), Card.of("4H"), Card.of("AC"));
    final List<Card> cards6 = Lists.newArrayList(Card.of("2H"), Card.of("4S"), Card.of("4D"), Card.of("4H"), Card.of("KC"));
    final List<Card> cards7 = Lists.newArrayList(Card.of("3H"), Card.of("4S"), Card.of("4D"), Card.of("4H"), Card.of("KD"));

    final ThreeOfAKind threeOfAKind = new ThreeOfAKind();

    assertEquals(-1, threeOfAKind.compare(cards1, cards2));
    assertEquals(1, threeOfAKind.compare(cards2, cards3));
    assertEquals(0, threeOfAKind.compare(cards4, cards5));
    assertEquals(1, threeOfAKind.compare(cards5, cards6));
    assertEquals(-1, threeOfAKind.compare(cards6, cards7));
  }

}
