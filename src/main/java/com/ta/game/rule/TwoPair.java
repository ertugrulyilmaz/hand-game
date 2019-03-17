package com.ta.game.rule;

import com.ta.game.entity.Card;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

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

  @Override
  public int compare(final List<Card> cards1, final List<Card> cards2) {
    checkArgument(check(cards1) && check(cards2));

    final int pairMin1;
    final int pairMax1;
    final int single1;
    if (cards1.get(0).getIndex() != cards1.get(1).getIndex()) {
      single1 = cards1.get(0).getIndex();
      pairMin1 = cards1.get(2).getIndex();
      pairMax1 = cards1.get(4).getIndex();
    } else if (cards1.get(3).getIndex() != cards1.get(4).getIndex()) {
      single1 = cards1.get(4).getIndex();
      pairMin1 = cards1.get(0).getIndex();
      pairMax1 = cards1.get(2).getIndex();
    } else {
      single1 = cards1.get(2).getIndex();
      pairMin1 = cards1.get(0).getIndex();
      pairMax1 = cards1.get(4).getIndex();
    }

    final int pairMin2;
    final int pairMax2;
    final int single2;
    if (cards2.get(0).getIndex() != cards2.get(1).getIndex()) {
      single2 = cards1.get(0).getIndex();
      pairMin2 = cards1.get(2).getIndex();
      pairMax2 = cards1.get(4).getIndex();
    } else if (cards2.get(3).getIndex() != cards2.get(4).getIndex()) {
      single2 = cards2.get(4).getIndex();
      pairMin2 = cards2.get(0).getIndex();
      pairMax2 = cards2.get(2).getIndex();
    } else {
      single2 = cards2.get(2).getIndex();
      pairMin2 = cards2.get(0).getIndex();
      pairMax2 = cards2.get(4).getIndex();
    }

    if (pairMax1 > pairMax2) {
      return 1;
    } else if (pairMax1 < pairMax2) {
      return -1;
    } else if (pairMin1 > pairMin2) {
      return 1;
    } else if (pairMin1 < pairMin2) {
      return -1;
    }

    return Integer.compare(single1, single2);
  }

}
