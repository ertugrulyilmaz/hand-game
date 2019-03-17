package com.ta.game.rule;

import com.ta.game.entity.Card;

import java.util.List;

public interface GameRule {

  boolean check(final List<Card> cards);

  int compare(final List<Card> cards1, final List<Card> cards2);

}
