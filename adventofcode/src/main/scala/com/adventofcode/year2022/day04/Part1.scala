package com.adventofcode.year2022.day04

/** Day 4: Camp Cleanup
  *   - https://adventofcode.com/2022/day/4
  */
object Part1 extends App {

  final case class Section(left: Int, right: Int)

  object Section {

    def apply: String => Section = { case s"$l-$r" =>
      val (left, right) = (l.toInt, r.toInt)
      Section(left min right, left max right)
    }
  }

  final case class Assignment(first: Section, second: Section) {

    def overlap: Boolean = {
      val Section(fleft, fright) = first
      val Section(sleft, sright) = second

      sleft <= fleft && fright <= sright ||
      fleft <= sleft && sright <= fright
    }
  }

  object Assignment {

    sealed trait Overlap

    def apply: String => Assignment = { case s"$f,$s" =>
      val first  = Section(f)
      val second = Section(s)

      Assignment(first, second)
    }
  }

  val sources     = scala.io.Source.fromResource("year2022/day04/input.txt").getLines().toList
  val assignments = sources.map(Assignment.apply)
  val answer      = assignments.count(_.overlap)

  println(answer)
}
