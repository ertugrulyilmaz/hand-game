package com.ta.game.rules;

import com.google.common.collect.Lists;
import com.ta.game.entity.Card;
import com.ta.game.rule.HighCard;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHighCardRule {

  @Test
  public void testComparisionOfTwoHand() {
    final List<Card> cards1 = Lists.newArrayList(Card.of("2S"), Card.of("4C"), Card.of("6D"), Card.of("QH"), Card.of("AS"));
    final List<Card> cards2 = Lists.newArrayList(Card.of("2S"), Card.of("6C"), Card.of("8D"), Card.of("TH"), Card.of("KS"));
    final List<Card> cards3 = Lists.newArrayList(Card.of("2S"), Card.of("4C"), Card.of("6D"), Card.of("8H"), Card.of("TS"));
    final List<Card> cards4 = Lists.newArrayList(Card.of("4S"), Card.of("6C"), Card.of("8D"), Card.of("TH"), Card.of("KS"));
    final List<Card> cards5 = Lists.newArrayList(Card.of("2S"), Card.of("4C"), Card.of("6D"), Card.of("QH"), Card.of("AS"));
    final List<Card> cards6 = Lists.newArrayList(Card.of("2S"), Card.of("4C"), Card.of("6D"), Card.of("QH"), Card.of("AS"));

    final HighCard highCard = new HighCard();

    assertEquals(1, highCard.compare(cards1, cards2));
    assertEquals(-1, highCard.compare(cards3, cards4));
    assertEquals(0, highCard.compare(cards5, cards6));
  }

}
