package com.ta.game.utils;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;

public class GameLabels {

  public static final Map<Character, Pair<String, Integer>> CARD_MAP = ImmutableMap.<Character, Pair<String, Integer>>builder()
  .put('2', Pair.of("2", 2))
  .put('3', Pair.of("3", 3))
  .put('4', Pair.of("4", 4))
  .put('5', Pair.of("5", 5))
  .put('6', Pair.of("6", 6))
  .put('7', Pair.of("7", 7))
  .put('8', Pair.of("8", 8))
  .put('9', Pair.of("9", 9))
  .put('T', Pair.of("Ten", 10))
  .put('J', Pair.of("Jack", 11))
  .put('Q', Pair.of("Queen", 12))
  .put('K', Pair.of("King", 13))
  .put('A', Pair.of("Ace", 14))
  .build();

}
