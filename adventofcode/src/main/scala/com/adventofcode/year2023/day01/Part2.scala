package com.adventofcode.year2023.day01

/** Day 1: Trebuchet?!
  *   - https://adventofcode.com/2023/day/1#part2
  */
object Part2 extends App {

  implicit final class StringOps(private val line: String) extends AnyVal {

    def number: Int = {
      val left = line
        .foldLeft("") { (state, char) => s"$state$char".toDigit }
        .toList
        .collect { case c if c.isDigit => c.toInt - 48 }
        .headOption

      val right = line
        .foldRight("") { (state, char) => s"$state$char".toDigit }
        .toList
        .collect { case c if c.isDigit => c.toInt - 48 }
        .lastOption

      val digits = (left :: right :: Nil).flatten

      digits match {
        case a :: Nil    => 10 * a + a
        case a +: _ :+ b => 10 * a + b
        case _           => 0
      }
    }

    def toDigit: String =
      line
        .replace("one", "1")
        .replace("two", "2")
        .replace("three", "3")
        .replace("four", "4")
        .replace("five", "5")
        .replace("six", "6")
        .replace("seven", "7")
        .replace("eight", "8")
        .replace("nine", "9")
  }

  val sources = scala.io.Source.fromResource("year2023/day01/input.txt").getLines().toList
  val answer  = sources.foldLeft(0L)(_ + _.number)

  println(answer)
}
