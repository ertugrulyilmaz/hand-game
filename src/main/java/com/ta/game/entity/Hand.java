package com.ta.game.entity;

import com.ta.game.entity.comperators.CardComperator;
import com.ta.game.entity.enums.CardValue;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Getter
public class Hand implements Comparable<Hand> {

  private final List<Card> cards;
  private final CardValue value;

  private Hand(final String[] cardArr) {
    this.cards = init(cardArr);
    this.value = valueOf(this.cards);
  }

  private List<Card> init(final String[] cardArr) {
    return Arrays.stream(cardArr)
    .map(Card::of)
    .sorted(new CardComperator())
    .collect(collectingAndThen(toList(), Collections::unmodifiableList));
  }

  public static Hand fromString(final String str) {
    checkArgument(!isNullOrEmpty(str));

    final String[] cardArr = str.split(" ");

    checkArgument(cardArr.length == 5);

    return new Hand(cardArr);
  }

  private CardValue valueOf(final List<Card> cards) {
    if (CardValue.ROYAL_FLUSH.check(cards)) {
      return CardValue.ROYAL_FLUSH;
    } else if (CardValue.STRAIGHT_FLUSH.check(cards)) {
      return CardValue.STRAIGHT_FLUSH;
    } else if (CardValue.FOUR_OF_A_KIND.check(cards)) {
      return CardValue.FOUR_OF_A_KIND;
    } else if (CardValue.FULL_HOUSE.check(cards)) {
      return CardValue.FULL_HOUSE;
    } else if (CardValue.FLUSH.check(cards)) {
      return CardValue.FLUSH;
    } else if (CardValue.STRAIGHT.check(cards)) {
      return CardValue.STRAIGHT;
    } else if (CardValue.THREE_OF_A_KIND.check(cards)) {
      return CardValue.THREE_OF_A_KIND;
    } else if (CardValue.TWO_PAIR.check(cards)) {
      return CardValue.TWO_PAIR;
    } else if (CardValue.ONE_PAIR.check(cards)) {
      return CardValue.ONE_PAIR;
    } else {
      return CardValue.HIGH_CARD;
    }
  }

  @Override
  public String toString() {
    final String hand = cards.stream()
    .map(Card::toString)
    .collect(Collectors.joining(" "));

    return new StringBuilder()
    .append("<hand ")
    .append("[")
    .append(hand)
    .append("]")
    .append(",")
    .append(" ")
    .append("'")
    .append(value.toString())
    .append("'")
    .append(">")
    .toString();
  }

  @Override
  public int compareTo(final Hand o) {
    if (value.ordinal() < o.getValue().ordinal()) {
      return 1;
    } else if (value.ordinal() > o.getValue().ordinal()) {
      return -1;
    } else {
      return value.getGameRule().compare(cards, o.getCards());
    }
  }
}
