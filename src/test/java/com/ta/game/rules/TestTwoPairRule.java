package com.ta.game.rules;

import com.google.common.collect.Lists;
import com.ta.game.entity.Card;
import com.ta.game.rule.TwoPair;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTwoPairRule {

  @Test
  public void testTwoPairRule() {
    final List<Card> cards1 = Lists.newArrayList(Card.of("2S"), Card.of("2H"), Card.of("3D"), Card.of("3H"), Card.of("AC"));
    final List<Card> cards2 = Lists.newArrayList(Card.of("4S"), Card.of("4H"), Card.of("5D"), Card.of("6H"), Card.of("6C"));
    final List<Card> cards3 = Lists.newArrayList(Card.of("3H"), Card.of("7S"), Card.of("7D"), Card.of("TH"), Card.of("TC"));
    final List<Card> cards4 = Lists.newArrayList(Card.of("2H"), Card.of("2S"), Card.of("3D"), Card.of("4H"), Card.of("5C"));
    final List<Card> cards5 = Lists.newArrayList(Card.of("2H"), Card.of("5S"), Card.of("5D"), Card.of("TH"), Card.of("QC"));
    final List<Card> cards6 = Lists.newArrayList(Card.of("2H"), Card.of("4S"), Card.of("5D"), Card.of("TH"), Card.of("QC"));

    final TwoPair twoPair = new TwoPair();

    assertTrue(twoPair.check(cards1));
    assertTrue(twoPair.check(cards2));
    assertTrue(twoPair.check(cards3));
    assertFalse(twoPair.check(cards4));
    assertFalse(twoPair.check(cards5));
    assertFalse(twoPair.check(cards6));
  }

  @Test
  public void testComparisionOfTwoHand() {
    final List<Card> cards1 = Lists.newArrayList(Card.of("2S"), Card.of("2H"), Card.of("3D"), Card.of("3H"), Card.of("AC"));
    final List<Card> cards2 = Lists.newArrayList(Card.of("4S"), Card.of("4H"), Card.of("5D"), Card.of("6H"), Card.of("6C"));
    final List<Card> cards3 = Lists.newArrayList(Card.of("3H"), Card.of("7S"), Card.of("7D"), Card.of("TH"), Card.of("TC"));
    final List<Card> cards4 = Lists.newArrayList(Card.of("2H"), Card.of("2S"), Card.of("5D"), Card.of("5H"), Card.of("8C"));
    final List<Card> cards5 = Lists.newArrayList(Card.of("2H"), Card.of("2C"), Card.of("5D"), Card.of("5H"), Card.of("8D"));
    final List<Card> cards6 = Lists.newArrayList(Card.of("2H"), Card.of("2C"), Card.of("5D"), Card.of("5H"), Card.of("9D"));

    final TwoPair twoPair = new TwoPair();

    assertEquals(-1, twoPair.compare(cards1, cards2));
    assertEquals(1, twoPair.compare(cards3, cards2));
    assertEquals(0, twoPair.compare(cards4, cards5));
    assertEquals(-1, twoPair.compare(cards5, cards6));
  }

}
