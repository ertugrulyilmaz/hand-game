package com.ta.game.entity.enums;

import com.ta.game.entity.Card;
import com.ta.game.rule.*;

import java.util.List;

public enum CardValue {

  ROYAL_FLUSH("Royal Flush", new RoyalFlush()),
  STRAIGHT_FLUSH("Straight Flush", new StraightFlush()),
  FOUR_OF_A_KIND("Four of a Kind", new FourOfAKind()),
  FULL_HOUSE("Full House", new FullHouse()),
  FLUSH("Flush", new Flush()),
  STRAIGHT("Straight", new Straight()),
  THREE_OF_A_KIND("Three of a Kind", new ThreeOfAKind()),
  TWO_PAIR("Two Pair", new TwoPair()),
  ONE_PAIR("One Pair", new OnePair()),
  HIGH_CARD("High Card", new HighCard());

  private final String label;
  private final GameRule gameRule;

  CardValue(final String label, final GameRule gameRule) {
    this.label = label;
    this.gameRule = gameRule;
  }

  public GameRule getGameRule() {
    return gameRule;
  }

  public boolean check(final List<Card> cards) {
    return gameRule.check(cards);
  }

  @Override
  public String toString() {
    return label;
  }

}
