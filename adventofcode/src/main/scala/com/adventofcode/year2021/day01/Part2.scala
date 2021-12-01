package com.adventofcode.year2021.day01

/** Day 1. Sonar Sweep. Part 2
  * https://adventofcode.com/2021/day/1#part2
  */
object Part2 extends App {
  val source = scala.io.Source.fromResource("year2021/day01/input.txt")

  val measurements      = source.getLines().map(_.toInt)
  val threeMeasurements = measurements.sliding(3, 1).map(_.sum).toList

  val (count, _) = threeMeasurements.tail.foldLeft((0, threeMeasurements.head)) {
    case ((count, previous), current) if current > previous => (count + 1, current)
    case ((count, _), current)                              => (count, current)
  }

  println(count)
}
