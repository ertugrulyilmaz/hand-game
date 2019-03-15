package com.ta.game.rule;

import com.ta.game.entity.Card;

import java.util.List;

public interface GameRule {

  boolean check(final List<Card> cards);

}
