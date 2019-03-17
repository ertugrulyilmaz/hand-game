package com.ta.game.rule;

import com.ta.game.entity.Card;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public final class Flush implements GameRule {

  @Override
  public boolean check(final List<Card> cards) {
    final Card card1 = cards.get(0);
    final Card card2 = cards.get(1);
    final Card card3 = cards.get(2);
    final Card card4 = cards.get(3);
    final Card card5 = cards.get(4);

    return (
    card1.getSuit() == card2.getSuit() &&
    card2.getSuit() == card3.getSuit() &&
    card3.getSuit() == card4.getSuit() &&
    card4.getSuit() == card5.getSuit()
    );
  }

  @Override
  public int compare(final List<Card> cards1, final List<Card> cards2) {
    checkArgument(check(cards1) && check(cards2));

    for (int i = cards1.size() - 1; i >= 0; i--) {
      final int card1 = cards1.get(i).getIndex();
      final int card2 = cards2.get(i).getIndex();

      if (card1 > card2) {
        return 1;
      } else if (card1 < card2) {
        return -1;
      }
    }

    return 0;
  }

}
