package com.adventofcode.year2022.day01

/** Day 1. Calorie Counting. Part 1:
  *   - https://adventofcode.com/2022/day/1#part1
  */
object Part1 extends App {
  sealed trait Line

  object Line {
    case object Blank              extends Line
    case class Item(calories: Int) extends Line

    def apply(line: String): Line =
      line.toIntOption.map(Item).getOrElse(Blank)
  }

  val input    = scala.io.Source.fromResource("year2022/day01/input.txt")
  val calories = input.getLines().toList.map(Line.apply)

  val answer = {
    val (most, total) = calories.foldLeft((0L, 0L)) {
      case ((most, total), Line.Blank)          => (most max total, 0L)
      case ((most, total), Line.Item(calories)) => (most, total + calories)
    }

    most max total
  }

  println(answer)
}
