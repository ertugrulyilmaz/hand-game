package com.ta.game.rules;

import com.google.common.collect.Lists;
import com.ta.game.entity.Card;
import com.ta.game.rule.FourOfAKind;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFourOfAKindRule {

  @Test
  public void testFourOfAKindRule() {
    final List<Card> cards1 = Lists.newArrayList(Card.of("2S"), Card.of("4C"), Card.of("4D"), Card.of("4H"), Card.of("4S"));
    final List<Card> cards2 = Lists.newArrayList(Card.of("4C"), Card.of("4D"), Card.of("4H"), Card.of("4S"), Card.of("AS"));
    final List<Card> cards3 = Lists.newArrayList(Card.of("4C"), Card.of("4D"), Card.of("5H"), Card.of("6S"), Card.of("6S"));
    final List<Card> cards4 = Lists.newArrayList(Card.of("2C"), Card.of("3D"), Card.of("4H"), Card.of("5S"), Card.of("6S"));
    final FourOfAKind fourOfAKind = new FourOfAKind();

    assertTrue(fourOfAKind.check(cards1));
    assertTrue(fourOfAKind.check(cards2));
    assertFalse(fourOfAKind.check(cards3));
    assertFalse(fourOfAKind.check(cards4));
  }

}
