package com.ta.game.entity.enums;

public enum  Suit {
  C("Clubs"),
  D("Diamonds"),
  H("Hearts"),
  S("Spades");

  private final String label;

  Suit(final String label) {
    this.label = label;
  }
}
