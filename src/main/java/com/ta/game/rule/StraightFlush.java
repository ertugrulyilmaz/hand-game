package com.ta.game.rule;

import com.ta.game.entity.Card;

import java.util.List;

public final class StraightFlush implements GameRule {

  @Override
  public boolean check(final List<Card> cards) {
    Card prevCard = cards.get(0);

    if (prevCard.getIndex() > 9) return false;

    for (int i = 1; i < cards.size(); i++) {
      final Card card = cards.get(i);

      if (card.getSuit() != prevCard.getSuit()) return false;
      if (card.getIndex() - prevCard.getIndex() != 1) return false;

      prevCard = card;
    }

    return true;
  }

}
