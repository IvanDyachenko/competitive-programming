package com.adventofcode.year2021.day01

/** Day 1. Sonar Sweep. Part 1
  * https://adventofcode.com/2021/day/1#part1
  */
object Part1 extends App {
  val source = scala.io.Source.fromResource("year2021/day01/input.txt")

  val measurements = source.getLines().toList.map(_.toInt)

  val (count, _) = measurements.tail.foldLeft((0, measurements.head)) {
    case ((count, previous), current) if current > previous => (count + 1, current)
    case ((count, _), current)                              => (count, current)
  }

  println(count)
}
