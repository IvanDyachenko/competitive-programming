package com.adventofcode.year2023.day04

/** Day 4: Scratchcards
  *   - https://adventofcode.com/2023/day/4#part2
  */
object Part2 extends App {

  final case class Scratchcard(index: Int, left: Set[Int], right: Set[Int]) {
    val matches: Int = (left intersect right).size
  }

  object Scratchcard {
    def apply: String => Scratchcard = { case s"Card $i: $ls | $rs" => Scratchcard(i.trim.toInt, parse(ls), parse(rs)) }

    private def parse: String => Set[Int] = _.split(' ').map(_.trim).flatMap(_.toIntOption).toSet[Int]
  }

  final case class Scratchcards(cards: List[Scratchcard]) {

    def total: Long = cards
      .sortBy(_.index)
      .foldLeft(Map.empty[Int, Int]) { case (index2count, card @ Scratchcard(i, ls, rs)) =>
        (0 until card.matches)
          .foldLeft(index2count) { (index2count, j) =>
            index2count.updatedWith(i + j + 1)(_.orElse(Some(0)).map(_ + index2count.getOrElse(i, 0) + 1))
          }
          .updatedWith(i)(_.orElse(Some(0)).map(_ + 1))
      }
      .values
      .foldLeft(0L)(_ + _)
  }

  object Scratchcards {
    def apply: List[String] => Scratchcards = xs => Scratchcards(xs.map(Scratchcard(_)))
  }

  val sources = scala.io.Source.fromResource("year2023/day04/input.txt").getLines.toList
  val answer  = Scratchcards(sources).total

  println(answer)
}
