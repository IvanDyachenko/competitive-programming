package com.adventofcode.year2023.day04

/** Day 4: Scratchcards
  *   - https://adventofcode.com/2023/day/4
  */
object Part1 extends App {

  final case class Card(target: Set[Int], numbers: Set[Int]) {

    def points: Long = (target intersect numbers).size match {
      case 0 => 0L
      case x => 1L << (x - 1)
    }
  }

  object Card {

    def apply(input: String): Card = input match {
      case s"Card $idx: $target | $numbers" =>
        Card(
          target.split(' ').flatMap(_.toIntOption).toSet,
          numbers.split(' ').flatMap(_.toIntOption).toSet
        )
    }
  }

  val sources = scala.io.Source.fromResource("year2023/day04/input.txt").getLines().toList
  val answer  = sources.map(Card.apply).map(_.points).sum

  println(answer)
}
