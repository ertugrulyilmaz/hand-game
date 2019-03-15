package com.ta.game.rule;

import com.ta.game.entity.Card;

import java.util.List;

public final class HighCard implements GameRule {

  @Override
  public boolean check(final List<Card> cards) {
    return true;
  }

}
