package com.ta.game.rule;

import com.ta.game.entity.Card;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public final class ThreeOfAKind implements GameRule {

  @Override
  public boolean check(final List<Card> cards) {
    final Card card1 = cards.get(0);
    final Card card2 = cards.get(1);
    final Card card3 = cards.get(2);
    final Card card4 = cards.get(3);
    final Card card5 = cards.get(4);

    return
    (card1.getIndex() == card2.getIndex() && card2.getIndex() == card3.getIndex()) ||
    (card2.getIndex() == card3.getIndex() && card3.getIndex() == card4.getIndex()) ||
    (card3.getIndex() == card4.getIndex() && card4.getIndex() == card5.getIndex())
    ;
  }

  @Override
  public int compare(final List<Card> cards1, final List<Card> cards2) {
    checkArgument(check(cards1) && check(cards2));

    final int card1same;
    final int card1min;
    final int card1max;
    if (cards1.get(0).getIndex() == cards1.get(1).getIndex() && cards1.get(1).getIndex() == cards1.get(2).getIndex()) {
      card1min = cards1.get(3).getIndex();
      card1max = cards1.get(4).getIndex();
      card1same = cards1.get(0).getIndex();
    } else if (cards1.get(1).getIndex() == cards1.get(2).getIndex() && cards1.get(2).getIndex() == cards1.get(3).getIndex()) {
      card1min = cards1.get(0).getIndex();
      card1max = cards1.get(4).getIndex();
      card1same = cards1.get(1).getIndex();
    } else {
      card1min = cards1.get(0).getIndex();
      card1max = cards1.get(1).getIndex();
      card1same = cards1.get(2).getIndex();
    }

    final int card2same;
    final int card2min;
    final int card2max;
    if (cards2.get(0).getIndex() == cards2.get(1).getIndex() && cards2.get(1).getIndex() == cards2.get(2).getIndex()) {
      card2min = cards2.get(3).getIndex();
      card2max = cards2.get(4).getIndex();
      card2same = cards2.get(0).getIndex();
    } else if (cards2.get(1).getIndex() == cards2.get(2).getIndex() && cards2.get(2).getIndex() == cards2.get(3).getIndex()) {
      card2min = cards2.get(0).getIndex();
      card2max = cards2.get(4).getIndex();
      card2same = cards2.get(1).getIndex();
    } else {
      card2min = cards2.get(0).getIndex();
      card2max = cards2.get(1).getIndex();
      card2same = cards2.get(2).getIndex();
    }

    if (card1same > card2same) return 1;
    else if (card1same < card2same) return -1;
    else {
      if (card1max > card2max) return 1;
      else if (card1max < card2max) return -1;
      else return Integer.compare(card1min, card2min);
    }
  }

}
