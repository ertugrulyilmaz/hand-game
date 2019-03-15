package com.ta.game.rules;

import com.google.common.collect.Lists;
import com.ta.game.entity.Card;
import com.ta.game.rule.Flush;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFlushRule {

  @Test
  public void testFlushRule() {
    final List<Card> cards1 = Lists.newArrayList(Card.of("TS"), Card.of("JS"), Card.of("QS"), Card.of("KS"), Card.of("AS"));
    final List<Card> cards2 = Lists.newArrayList(Card.of("3C"), Card.of("4C"), Card.of("7C"), Card.of("TC"), Card.of("AC"));
    final List<Card> cards3 = Lists.newArrayList(Card.of("3H"), Card.of("5H"), Card.of("TH"), Card.of("JH"), Card.of("AH"));
    final List<Card> cards4 = Lists.newArrayList(Card.of("2D"), Card.of("6D"), Card.of("8D"), Card.of("TD"), Card.of("AD"));
    final List<Card> cards5 = Lists.newArrayList(Card.of("9S"), Card.of("JC"), Card.of("QS"), Card.of("KS"), Card.of("AS"));
    final List<Card> cards6 = Lists.newArrayList(Card.of("TS"), Card.of("JC"), Card.of("QS"), Card.of("KS"), Card.of("AC"));
    final List<Card> cards7 = Lists.newArrayList(Card.of("TS"), Card.of("JH"), Card.of("QD"), Card.of("KS"), Card.of("9S"));
    final Flush flush = new Flush();

    assertTrue(flush.check(cards1));
    assertTrue(flush.check(cards2));
    assertTrue(flush.check(cards3));
    assertTrue(flush.check(cards4));
    assertFalse(flush.check(cards5));
    assertFalse(flush.check(cards6));
    assertFalse(flush.check(cards7));
  }

}
