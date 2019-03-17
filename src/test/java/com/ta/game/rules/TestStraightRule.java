package com.ta.game.rules;

import com.google.common.collect.Lists;
import com.ta.game.entity.Card;
import com.ta.game.rule.Straight;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestStraightRule {

  @Test
  public void testStraightRule() {
    final List<Card> cards1 = Lists.newArrayList(Card.of("2S"), Card.of("3S"), Card.of("4D"), Card.of("5H"), Card.of("AC"));
    final List<Card> cards2 = Lists.newArrayList(Card.of("TS"), Card.of("JS"), Card.of("QD"), Card.of("KH"), Card.of("AC"));
    final List<Card> cards3 = Lists.newArrayList(Card.of("3H"), Card.of("4S"), Card.of("5D"), Card.of("6H"), Card.of("7C"));
    final List<Card> cards4 = Lists.newArrayList(Card.of("3H"), Card.of("4S"), Card.of("5D"), Card.of("6H"), Card.of("8C"));
    final List<Card> cards5 = Lists.newArrayList(Card.of("2H"), Card.of("4S"), Card.of("5D"), Card.of("6H"), Card.of("8C"));

    final Straight straight = new Straight();

    assertTrue(straight.check(cards1));
    assertTrue(straight.check(cards2));
    assertTrue(straight.check(cards3));
    assertFalse(straight.check(cards4));
    assertFalse(straight.check(cards5));
  }

  @Test
  public void testComparisionOfTwoHand() {
    final List<Card> cards1 = Lists.newArrayList(Card.of("2S"), Card.of("3S"), Card.of("4D"), Card.of("5H"), Card.of("AC"));
    final List<Card> cards2 = Lists.newArrayList(Card.of("TS"), Card.of("JS"), Card.of("QD"), Card.of("KH"), Card.of("AC"));
    final List<Card> cards3 = Lists.newArrayList(Card.of("3H"), Card.of("4S"), Card.of("5D"), Card.of("6H"), Card.of("7C"));
    final List<Card> cards4 = Lists.newArrayList(Card.of("3D"), Card.of("4S"), Card.of("5D"), Card.of("6H"), Card.of("7C"));

    final Straight straight = new Straight();

    assertEquals(-1, straight.compare(cards1, cards2));
    assertEquals(1, straight.compare(cards2, cards3));
    assertEquals(0, straight.compare(cards3, cards4));
  }

}
