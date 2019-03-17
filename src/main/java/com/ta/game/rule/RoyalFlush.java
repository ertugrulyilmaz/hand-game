package com.ta.game.rule;

import com.ta.game.entity.Card;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public final class RoyalFlush implements GameRule {

  @Override
  public boolean check(final List<Card> cards) {
    Card prevCard = cards.get(0);

    if (prevCard.getCard() != 'T') return false;

    for (int i = 1; i < cards.size(); i++) {
      final Card card = cards.get(i);

      if (card.getSuit() != prevCard.getSuit()) return false;
      if (card.getIndex() - prevCard.getIndex() != 1) return false;

      prevCard = card;
    }

    return true;
  }

  @Override
  public int compare(final List<Card> cards1, final List<Card> cards2) {
    checkArgument(check(cards1) && check(cards2));

    return 0;
  }

}
