package com.ta.game;

import com.ta.game.entity.Hand;

public class Application {

  public static void main(String[] args) {
    final Hand royalFlush = Hand.fromString("TS JS QS KS AS");
    final Hand straightFlush = Hand.fromString("5S 6S 7S 8S 9S");
    final Hand fourOfAKind = Hand.fromString("7S TC TH TS TD");
    final Hand fullHouse = Hand.fromString("5H 5C QD QC QS");
    final Hand flush = Hand.fromString("2D 3D 7D QD AD");
    final Hand straight = Hand.fromString("4D 5D 6D 7H 8D");
    final Hand threeOfAKind = Hand.fromString("4D 4H 4S 7H 8D");
    final Hand twoPair = Hand.fromString("4D 4H 7S 7H QD");
    final Hand onePair = Hand.fromString("4D 4H 7S QH AD");
    final Hand highCard = Hand.fromString("2D 4C 6D 7H AD");

    System.out.println(royalFlush);
    System.out.println(straightFlush);
    System.out.println(fourOfAKind);
    System.out.println(fullHouse);
    System.out.println(flush);
    System.out.println(straight);
    System.out.println(threeOfAKind);
    System.out.println(twoPair);
    System.out.println(onePair);
    System.out.println(highCard);
  }

}
