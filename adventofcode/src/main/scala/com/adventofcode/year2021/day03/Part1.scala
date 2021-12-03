package com.adventofcode.year2021.day03

/** Day 3. Binary Diagnostic. Part 1
  * https://adventofcode.com/2021/day/3
  */
object Part1 extends App {
  val source = scala.io.Source.fromResource("year2021/day03/input.txt").getLines().toList

  val (gamma, epsilon) = source.transpose.foldLeft((0, 0)) { case ((gamma, epsilon), column) =>
    val ones  = column.count(_ == '1')
    val zeros = column.count(_ == '0')

    (
      (gamma << 1) + (if (ones > zeros) 1 else 0),
      (epsilon << 1) + (if (ones > zeros) 0 else 1)
    )
  }

  val result = 1L * gamma * epsilon

  println(s"gamma=$gamma epsilon=$epsilon result=$result")
}
