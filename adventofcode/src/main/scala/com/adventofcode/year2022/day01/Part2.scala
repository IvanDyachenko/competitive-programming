package com.adventofcode.year2022.day01

import scala.collection.mutable

/** Day 1. Calorie Counting. Part 2:
  *   - https://adventofcode.com/2022/day/1#part2
  */
object Part2 extends App {
  sealed trait Line

  object Line {
    case object Blank              extends Line
    case class Item(calories: Int) extends Line

    def apply(line: String): Line =
      line.toIntOption.map(Item).getOrElse(Blank)
  }

  final case class Elves(count: Int) {
    private val queue: mutable.PriorityQueue[Long] =
      mutable.PriorityQueue.empty[Long](Ordering[Long].reverse)

    def get: Long =
      queue.dequeueAll.sum

    def add(calories: Long): Unit =
      if (queue.length < 3) queue += calories
      else queue += calories max queue.dequeue()
  }

  val input = scala.io.Source.fromResource("year2022/day01/input.txt")
  val lines = input.getLines().toList.map(Line.apply)

  val answer = {
    val elves = Elves(3)

    val total = lines.foldLeft(0L) {
      case (total, Line.Blank)          =>
        elves.add(total)
        0L
      case (total, Line.Item(calories)) =>
        total + calories
    }
    elves.add(total)

    elves.get
  }

  println(answer)
}
