package com.ta.game.entity.comperators;

import com.ta.game.entity.Card;

import java.util.Comparator;

public class CardComperator implements Comparator<Card> {

  @Override
  public int compare(final Card card1, final Card card2) {
    if (card1.getIndex() > card2.getIndex()) return 1;
    else if (card1.getIndex() < card2.getIndex()) return -1;
    else return 0;
  }

}
