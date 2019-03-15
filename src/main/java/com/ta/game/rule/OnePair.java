package com.ta.game.rule;

import com.ta.game.entity.Card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class OnePair implements GameRule {

  @Override
  public boolean check(final List<Card> cards) {
    final Map<Integer, Boolean> map = new HashMap<>();

    for (Card card : cards) {
      map.putIfAbsent(card.getIndex(), true);
    }

    return map.size() == 4;
  }

}
