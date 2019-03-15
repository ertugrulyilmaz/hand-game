package com.ta.game.rule;

import com.ta.game.entity.Card;

import java.util.List;

public final class TwoPair implements GameRule {

  @Override
  public boolean check(final List<Card> cards) {
    final Card card1 = cards.get(0);
    final Card card2 = cards.get(1);
    final Card card3 = cards.get(2);
    final Card card4 = cards.get(3);
    final Card card5 = cards.get(4);

    return
    (card1.getIndex() == card2.getIndex() && card3.getIndex() == card4.getIndex()) ||
    (card2.getIndex() == card3.getIndex() && card4.getIndex() == card5.getIndex()) ||
    (card1.getIndex() == card2.getIndex() && card4.getIndex() == card5.getIndex())
    ;
  }

}
