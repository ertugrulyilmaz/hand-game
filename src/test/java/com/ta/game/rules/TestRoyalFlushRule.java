package com.ta.game.rules;

import com.google.common.collect.Lists;
import com.ta.game.entity.Card;
import com.ta.game.rule.RoyalFlush;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRoyalFlushRule {

  @Test
  public void testRoyalFlushRule() {
    final List<Card> cards1 = Lists.newArrayList(Card.of("TS"), Card.of("JS"), Card.of("QS"), Card.of("KS"), Card.of("AS"));
    final List<Card> cards2 = Lists.newArrayList(Card.of("TC"), Card.of("JC"), Card.of("QC"), Card.of("KC"), Card.of("AC"));
    final List<Card> cards3 = Lists.newArrayList(Card.of("TH"), Card.of("JH"), Card.of("QH"), Card.of("KH"), Card.of("AH"));
    final List<Card> cards4 = Lists.newArrayList(Card.of("TD"), Card.of("JD"), Card.of("QD"), Card.of("KD"), Card.of("AD"));
    final List<Card> cards5 = Lists.newArrayList(Card.of("9S"), Card.of("JS"), Card.of("QS"), Card.of("KS"), Card.of("AS"));
    final List<Card> cards6 = Lists.newArrayList(Card.of("TS"), Card.of("JS"), Card.of("QS"), Card.of("KS"), Card.of("AC"));
    final List<Card> cards7 = Lists.newArrayList(Card.of("TS"), Card.of("JS"), Card.of("QS"), Card.of("KS"), Card.of("9S"));
    final RoyalFlush royalFlush = new RoyalFlush();

    assertTrue(royalFlush.check(cards1));
    assertTrue(royalFlush.check(cards2));
    assertTrue(royalFlush.check(cards3));
    assertTrue(royalFlush.check(cards4));
    assertFalse(royalFlush.check(cards5));
    assertFalse(royalFlush.check(cards6));
    assertFalse(royalFlush.check(cards7));
  }

}
