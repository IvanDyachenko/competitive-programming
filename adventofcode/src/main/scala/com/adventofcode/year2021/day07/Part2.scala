package com.adventofcode.year2021.day07

/** Day 7. The Treachery of Whales. Part 2
  * https://adventofcode.com/2021/day/7#part2
  */
object Part2 extends App {
  val source = scala.io.Source.fromResource("year2021/day07/input.txt").getLines().mkString("")

  val positions = source.split(",").map(_.toInt).sorted

  val size      = positions.max + 1
  val distances = Array.fill(size, size)(0L)

  for {
    i <- 0 until size
    j <- i until size if i != j
    l  = j - i
    d  = l * (l + 1L) / 2L
  } {
    distances(i)(j) = d
    distances(j)(i) = d
  }

  val total = (0 until size).foldLeft(Long.MaxValue) { (total, index) =>
    total min positions.foldLeft(0L)(_ + distances(index)(_))
  }

  println(s"How much fuel must they spend to align to that position? $total")
}
