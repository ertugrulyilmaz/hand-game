package com.ta.game.rule;

import com.ta.game.entity.Card;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public final class Straight implements GameRule {

  @Override
  public boolean check(final List<Card> cards) {
    final Card card1 = cards.get(0);
    final Card card2 = cards.get(1);
    final Card card3 = cards.get(2);
    final Card card4 = cards.get(3);
    final Card card5 = cards.get(4);

    if (card1.getIndex() == 2 && card2.getIndex() == 3 && card3.getIndex() == 4 && card4.getIndex() == 5 && card5.getIndex() == 14) {
      return true;
    }

    Card prevCard = cards.get(0);

    for (int i = 1; i < cards.size(); i++) {
      final Card card = cards.get(i);

      if (card.getIndex() - prevCard.getIndex() != 1) return false;

      prevCard = card;
    }

    return true;
  }

  @Override
  public int compare(final List<Card> cards1, final List<Card> cards2) {
    checkArgument(check(cards1) && check(cards2));

    final int card1 = cards1.get(0).getIndex();
    final int card2 = cards2.get(0).getIndex();

    return Integer.compare(card1, card2);
  }

}
