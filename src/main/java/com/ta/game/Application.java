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

    System.out.println(royalFlush.toString() + " is higher than " + straightFlush + ", " + (royalFlush.getValue().ordinal() < straightFlush.getValue().ordinal()));
    System.out.println(straightFlush.toString() + " is higher than " + fourOfAKind + ", " + (straightFlush.getValue().ordinal() < fourOfAKind.getValue().ordinal()));
    System.out.println(fourOfAKind.toString() + " is higher than " + fullHouse + ", " + (fourOfAKind.getValue().ordinal() < fullHouse.getValue().ordinal()));
    System.out.println(fullHouse.toString() + " is higher than " + flush + ", " + (fullHouse.getValue().ordinal() < flush.getValue().ordinal()));
    System.out.println(flush.toString() + " is higher than " + straight + ", " + (flush.getValue().ordinal() < straight.getValue().ordinal()));
    System.out.println(straight.toString() + " is higher than " + threeOfAKind + ", " + (straight.getValue().ordinal() < threeOfAKind.getValue().ordinal()));
    System.out.println(threeOfAKind.toString() + " is higher than " + twoPair + ", " + (threeOfAKind.getValue().ordinal() < twoPair.getValue().ordinal()));
    System.out.println(twoPair.toString() + " is higher than " + onePair + ", " + (twoPair.getValue().ordinal() < onePair.getValue().ordinal()));
    System.out.println(onePair.toString() + " is higher than " + highCard + ", " + (onePair.getValue().ordinal() < highCard.getValue().ordinal()));
  }

}
