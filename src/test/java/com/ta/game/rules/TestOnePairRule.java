package com.ta.game.rules;

import com.google.common.collect.Lists;
import com.ta.game.entity.Card;
import com.ta.game.rule.OnePair;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestOnePairRule {

  @Test
  public void testOnePairRule() {
    final List<Card> cards1 = Lists.newArrayList(Card.of("2S"), Card.of("2H"), Card.of("3D"), Card.of("7H"), Card.of("AC"));
    final List<Card> cards2 = Lists.newArrayList(Card.of("2S"), Card.of("5H"), Card.of("5D"), Card.of("8H"), Card.of("9C"));
    final List<Card> cards3 = Lists.newArrayList(Card.of("3H"), Card.of("7S"), Card.of("9D"), Card.of("TH"), Card.of("TC"));
    final List<Card> cards4 = Lists.newArrayList(Card.of("2H"), Card.of("4S"), Card.of("6D"), Card.of("6H"), Card.of("AC"));
    final List<Card> cards5 = Lists.newArrayList(Card.of("2H"), Card.of("5S"), Card.of("7D"), Card.of("TH"), Card.of("QC"));

    final OnePair onePair = new OnePair();

    assertTrue(onePair.check(cards1));
    assertTrue(onePair.check(cards2));
    assertTrue(onePair.check(cards3));
    assertTrue(onePair.check(cards4));
    assertFalse(onePair.check(cards5));
  }

}
