package com.ta.game.entity;

import com.google.common.base.Enums;
import com.ta.game.entity.enums.Suit;
import lombok.Getter;
import lombok.NonNull;
import org.apache.commons.lang3.tuple.Pair;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.ta.game.utils.GameLabels.CARD_MAP;

@Getter
public final class Card {

  @NonNull private final char card;
  @NonNull private final String label;
  @NonNull private final int index;
  @NonNull private final Suit suit;

  private Card(final char card, final String label, final int index, final Suit suit) {
    this.card = card;
    this.label = label;
    this.index = index;
    this.suit = suit;
  }

  public static Card of(final String str) {
    checkArgument(!isNullOrEmpty(str));
    checkArgument(str.length() == 2);

    char card = str.charAt(0);
    String suit = str.charAt(1) + "";

    checkArgument(CARD_MAP.containsKey(card));
    checkArgument(Enums.getIfPresent(Suit.class, suit).isPresent());

    final Pair<String, Integer> pair = CARD_MAP.get(card);

    return new Card(card, pair.getLeft(), pair.getRight(), Suit.valueOf(suit));
  }

  @Override
  public String toString() {
    return card + "" + suit;
  }
}
