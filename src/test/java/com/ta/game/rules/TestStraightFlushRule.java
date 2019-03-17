package com.ta.game.rules;

import com.google.common.collect.Lists;
import com.ta.game.entity.Card;
import com.ta.game.rule.StraightFlush;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestStraightFlushRule {

  @Test
  public void testStraightFlushRule() {
    final List<Card> cards1 = Lists.newArrayList(Card.of("TS"), Card.of("JS"), Card.of("QS"), Card.of("KS"), Card.of("AS"));
    final List<Card> cards2 = Lists.newArrayList(Card.of("TC"), Card.of("JC"), Card.of("QC"), Card.of("KC"), Card.of("AC"));
    final List<Card> cards3 = Lists.newArrayList(Card.of("TH"), Card.of("JH"), Card.of("QH"), Card.of("KH"), Card.of("AH"));
    final List<Card> cards4 = Lists.newArrayList(Card.of("TD"), Card.of("JD"), Card.of("QD"), Card.of("KD"), Card.of("AD"));

    final List<Card> cards5 = Lists.newArrayList(Card.of("2S"), Card.of("3S"), Card.of("4S"), Card.of("5S"), Card.of("6S"));
    final List<Card> cards6 = Lists.newArrayList(Card.of("9C"), Card.of("TC"), Card.of("JC"), Card.of("QC"), Card.of("KC"));
    final List<Card> cards7 = Lists.newArrayList(Card.of("5H"), Card.of("6H"), Card.of("7H"), Card.of("8H"), Card.of("9H"));
    final List<Card> cards8 = Lists.newArrayList(Card.of("4D"), Card.of("5D"), Card.of("6D"), Card.of("7D"), Card.of("8D"));
    final List<Card> cards9 = Lists.newArrayList(Card.of("3D"), Card.of("4D"), Card.of("5D"), Card.of("6D"), Card.of("7D"));
    final List<Card> cards10 = Lists.newArrayList(Card.of("2S"), Card.of("3S"), Card.of("4S"), Card.of("5S"), Card.of("6H"));

    final StraightFlush straightFlush = new StraightFlush();

    assertFalse(straightFlush.check(cards1));
    assertFalse(straightFlush.check(cards2));
    assertFalse(straightFlush.check(cards3));
    assertFalse(straightFlush.check(cards4));
    assertTrue(straightFlush.check(cards5));
    assertTrue(straightFlush.check(cards6));
    assertTrue(straightFlush.check(cards7));
    assertTrue(straightFlush.check(cards8));
    assertTrue(straightFlush.check(cards9));
    assertFalse(straightFlush.check(cards10));
  }

  @Test
  public void testComparisionOfTwoHand() {
    final List<Card> cards1 = Lists.newArrayList(Card.of("2S"), Card.of("3S"), Card.of("4S"), Card.of("5S"), Card.of("6S"));
    final List<Card> cards2 = Lists.newArrayList(Card.of("9C"), Card.of("TC"), Card.of("JC"), Card.of("QC"), Card.of("KC"));
    final List<Card> cards3 = Lists.newArrayList(Card.of("5H"), Card.of("6H"), Card.of("7H"), Card.of("8H"), Card.of("9H"));
    final List<Card> cards4 = Lists.newArrayList(Card.of("5D"), Card.of("6D"), Card.of("7D"), Card.of("8D"), Card.of("9D"));

    final StraightFlush straightFlush = new StraightFlush();

    assertEquals(-1, straightFlush.compare(cards1, cards2));
    assertEquals(1, straightFlush.compare(cards2, cards3));
    assertEquals(0, straightFlush.compare(cards3, cards4));
  }

}
