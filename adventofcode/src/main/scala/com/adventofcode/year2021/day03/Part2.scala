package com.adventofcode.year2021.day03

/** Day 3. Binary Diagnostic. Part 2
  * https://adventofcode.com/2021/day/3#part2
  */
object Part2 extends App {
  val source = scala.io.Source.fromResource("year2021/day03/input.txt").getLines().toList

  def rating(inputs: List[String], transform: List[String] => (Int, List[String])): Int = {
    @annotation.tailrec
    def go(rating: Int, inputs: List[String]): Int =
      inputs match {
        case Nil => rating
        case _   =>
          val (delta, outputs) = transform(inputs)
          go((rating << 1) + delta, outputs)
      }

    go(0, inputs)
  }

  def transform(predicate: (Int, Int) => Boolean)(inputs: List[String]): (Int, List[String]) = {
    val (ones, zeros) = inputs.partition(_.head == '1')

    if (predicate(ones.length, zeros.length))
      (1, ones.map(_.tail).filter(_.nonEmpty))
    else
      (0, zeros.map(_.tail).filter(_.nonEmpty))
  }

  val o   = rating(source, transform((ones, zeros) => zeros == 0 || ones >= zeros))
  val co2 = rating(source, transform((ones, zeros) => zeros == 0 || ones != 0 && ones < zeros))

  val result = 1L * o * co2

  println(s"o=$o co2=$co2 result=$result")
}
