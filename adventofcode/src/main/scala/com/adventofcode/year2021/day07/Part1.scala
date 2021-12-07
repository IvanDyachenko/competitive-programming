package com.adventofcode.year2021.day07

/** Day 7. The Treachery of Whales. Part 1
  * https://adventofcode.com/2021/day/7
  */
object Part1 extends App {
  val source = scala.io.Source.fromResource("year2021/day07/input.txt").getLines().mkString("")

  val positions = source.split(",").map(_.toInt).sorted

  val total = positions.headOption.map { first =>
    val size  = positions.length
    val total = positions.foldLeft(0)(_ + _ - first)

    positions.zipWithIndex.tail
      .foldLeft((total, first, total)) {
        case (state @ (_, previous, _), (current, _)) if previous == current => state
        case ((result, previous, total), (current, index))                   =>
          val left  = index * (current - previous)
          val right = (size - index) * (current - previous)

          val pretendent = total + left - right

          (result min pretendent, current, pretendent)
      }
      ._1
  }

  println(s"How much fuel must they spend to align to that position? ${total.get}")
}
