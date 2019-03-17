package com.ta.game.rule;

import com.ta.game.entity.Card;

import java.lang.reflect.Array;
import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;

public final class OnePair implements GameRule {

  @Override
  public boolean check(final List<Card> cards) {
    final Map<Integer, Boolean> map = new HashMap<>();

    for (Card card : cards) {
      map.putIfAbsent(card.getIndex(), true);
    }

    return map.size() == 4;
  }

  @Override
  public int compare(final List<Card> cards1, final List<Card> cards2) {
    checkArgument(check(cards1) && check(cards2));

    int pair1 = 0;
    final Stack<Integer> others1 = new Stack<>();
    int prev = cards1.get(0).getIndex();
    others1.push(prev);

    for (int i = 1; i < cards1.size(); i++) {
      if (prev == cards1.get(i).getIndex()) {
        pair1 = cards1.get(i).getIndex();
        others1.pop();
      } else {
        others1.push(cards1.get(i).getIndex());
      }

      prev = cards1.get(i).getIndex();
    }

    int pair2 = 0;
    final Stack<Integer> others2 = new Stack<>();
    prev = cards2.get(0).getIndex();
    others2.push(prev);

    for (int i = 1; i < cards2.size(); i++) {
      if (prev == cards2.get(i).getIndex()) {
        pair2 = cards2.get(i).getIndex();
        others2.pop();
      } else {
        others2.push(cards2.get(i).getIndex());
      }

      prev = cards2.get(i).getIndex();
    }

    if (pair1 > pair2) return 1;
    else if (pair1 < pair2) return -1;

    for (int i = 0; i < others1.size(); i++) {
      if (others1.get(i) > others2.get(i)) {
        return 1;
      } else if (others1.get(i) < others2.get(i)) {
        return -1;
      }
    }

    return 0;
  }

}
