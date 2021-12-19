package com.adventofcode.year2021.day09

/** Day 9: Smoke Basin. Part 1
  * https://adventofcode.com/2021/day/9
  */
object Part1 extends App {
  val source = scala.io.Source.fromResource("year2021/day09/input.txt").getLines()

  val heightmap = source.toArray.map(_.split("").map(_.toInt))

  val n = heightmap.length
  val m = heightmap.headOption.map(_.length).getOrElse(0)

  val result = (0 until n).foldLeft(0) { (result, i) =>
    (0 until m).foldLeft(result) { (result, j) =>
      val up    = if (i > 0) heightmap(i - 1)(j) else 9
      val down  = if (i < n - 1) heightmap(i + 1)(j) else 9
      val left  = if (j > 0) heightmap(i)(j - 1) else 9
      val right = if (j < m - 1) heightmap(i)(j + 1) else 9

      val current = heightmap(i)(j)

      if (current < (up min down min left min right)) result + current + 1
      else result
    }
  }

  println(s"What is the sum of the risk levels of all low points on your heightmap? $result")
}
