package com.ta.game.rule;

import com.ta.game.entity.Card;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public final class FourOfAKind implements GameRule {

  @Override
  public boolean check(final List<Card> cards) {
    final Card card1 = cards.get(0);
    final Card card2 = cards.get(1);
    final Card card3 = cards.get(2);
    final Card card4 = cards.get(3);
    final Card card5 = cards.get(4);

    return (
    (card1.getIndex() == card2.getIndex() && card4.getIndex() != card5.getIndex()) ||
    (card1.getIndex() != card2.getIndex() && card4.getIndex() == card5.getIndex())
    )
    &&
    (card2.getIndex() == card3.getIndex() && card3.getIndex() == card4.getIndex());
  }

  @Override
  public int compare(final List<Card> cards1, final List<Card> cards2) {
    checkArgument(check(cards1) && check(cards2));

    final int card1;
    final int single1;
    if (cards1.get(0).getIndex() == cards1.get(1).getIndex()) {
      card1 = cards1.get(0).getIndex();
      single1 = cards1.get(4).getIndex();
    } else {
      card1 = cards1.get(1).getIndex();
      single1 = cards1.get(0).getIndex();
    }

    final int card2;
    final int single2;
    if (cards2.get(0).getIndex() == cards2.get(1).getIndex()) {
      card2 = cards2.get(0).getIndex();
      single2 = cards2.get(4).getIndex();
    } else {
      card2 = cards2.get(1).getIndex();
      single2 = cards2.get(0).getIndex();
    }

    if (card1 > card2) return 1;
    else if (card1 < card2) return -1;
    else return Integer.compare(single1, single2);
  }

}
