package com.ta.game.rule;

import com.ta.game.entity.Card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

public final class FullHouse implements GameRule {

  @Override
  public boolean check(final List<Card> cards) {
    final Card card1 = cards.get(0);
    final Card card2 = cards.get(1);
    final Card card3 = cards.get(2);
    final Card card4 = cards.get(3);
    final Card card5 = cards.get(4);

    return (
    (card1.getIndex() == card2.getIndex() && card2.getIndex() == card3.getIndex() && card3.getIndex() != card4.getIndex() && card4.getIndex() == card5.getIndex()) ||
    (card1.getIndex() == card2.getIndex() && card2.getIndex() != card3.getIndex() && card3.getIndex() == card4.getIndex() && card4.getIndex() == card5.getIndex())
    );
  }

  @Override
  public int compare(final List<Card> cards1, final List<Card> cards2) {
    checkArgument(check(cards1) && check(cards2));

    final int card21;
    final int card31;
    if (cards1.get(1).getIndex() == cards1.get(2).getIndex()) {
      card31 = cards1.get(2).getIndex();
      card21 = cards1.get(4).getIndex();
    } else {
      card31 = cards1.get(2).getIndex();
      card21 = cards1.get(0).getIndex();
    }

    final int card22;
    final int card32;
    if (cards2.get(1).getIndex() == cards2.get(2).getIndex()) {
      card32 = cards2.get(2).getIndex();
      card22 = cards2.get(4).getIndex();
    } else {
      card32 = cards2.get(2).getIndex();
      card22 = cards2.get(0).getIndex();
    }

    if (card31 > card32) return 1;
    else if (card31 < card32) return -1;
    else return Integer.compare(card21, card22);
  }

}
