package com.adventofcode.year2023.day01

/** Day 1: Trebuchet?!
  *   - https://adventofcode.com/2023/day/1
  */
object Part1 extends App {

  implicit final class StringOps(private val line: String) extends AnyVal {

    def number: Int = {
      val digits = line.toList.collect { case c if c.isDigit => c.toInt - 48 }

      digits match {
        case a :: Nil    => 10 * a + a
        case a +: _ :+ b => 10 * a + b
        case _           => 0
      }
    }
  }

  val sources = scala.io.Source.fromResource("year2023/day01/input.txt").getLines().toList
  val answer  = sources.foldLeft(0L)(_ + _.number)

  println(answer)
}
