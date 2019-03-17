package com.ta.game.rule;

import com.ta.game.entity.Card;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public final class HighCard implements GameRule {

  @Override
  public boolean check(final List<Card> cards) {
    return true;
  }

  @Override
  public int compare(final List<Card> cards1, final List<Card> cards2) {
    checkArgument(check(cards1) && check(cards2));

    for (int i = cards1.size() - 1; i > 0; i--) {
      if (cards1.get(i).getIndex() > cards2.get(i).getIndex()) return 1;
      else if (cards1.get(i).getIndex() < cards2.get(i).getIndex()) return -1;
    }

    return 0;
  }

}
