package com.adventofcode.year2022.day03

/** Day 3: Rucksack Reorganization
  *   - https://adventofcode.com/2022/day/3
  */
object Part1 extends App {

  final case class Rucksack(first: Rucksack.Compartment, second: Rucksack.Compartment) {
    def priority: Int = (first.priorities intersect second.priorities).foldLeft(0)(_ + _)
  }

  object Rucksack {

    final case class Compartment(priorities: Set[Byte]) extends AnyVal

    object Compartment {

      def apply(half: String): Compartment = {
        val priorities = half.collect {
          case char if char.isLetter && char.isLower => char - 96
          case char if char.isLetter && char.isUpper => char - 38
        }.map(_.toByte).toSet

        Compartment(priorities)
      }
    }

    def apply(line: String): Rucksack = {
      val (left, right) = line.splitAt(line.length / 2)

      Rucksack(Compartment(left), Compartment(right))
    }
  }

  val sources   = scala.io.Source.fromResource("year2022/day03/input.txt").getLines().toList
  val rucksacks = sources.map(Rucksack.apply)
  val answer    = rucksacks.foldLeft(0)(_ + _.priority)

  println(answer)
}
