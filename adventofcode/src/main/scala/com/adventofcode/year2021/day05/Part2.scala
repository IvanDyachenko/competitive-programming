package com.adventofcode.year2021.day05

/** Day 5. Hydrothermal Venture. Part 2
  * https://adventofcode.com/2021/day/5#part2
  */
object Part2 extends App {
  val source = scala.io.Source.fromResource("year2021/day05/input.txt").getLines().toList

  type Coordinate = (Int, Int)

  final case class HydrothermalVent(start: Coordinate, end: Coordinate)

  object HydrothermalVent {
    def fromString(input: String): HydrothermalVent = input match {
      case s"$x1,$y1 -> $x2,$y2" => HydrothermalVent((x1.toInt, y1.toInt), (x2.toInt, y2.toInt))
    }
  }

  final case class Field(vents: List[HydrothermalVent]) {
    private val field: Array[Array[Int]] = {
      val data = Array.fill(10000)(Array.fill(10000)(0))

      @annotation.tailrec
      def go(p1: Coordinate, p2: Coordinate): Unit = {
        val dx = (p1._1 - p2._1).signum
        val dy = (p1._2 - p2._2).signum

        data(p1._1)(p1._2) += 1
        if (p1 != p2) go((p1._1 - dx, p1._2 - dy), p2)
      }

      vents.foreach { case HydrothermalVent(p1, p2) => go(p1, p2) }
      data
    }

    val overlaps: Int = field.foldLeft(0)(_ + _.count(_ > 1))
  }

  object Field {
    def fromString(input: Seq[String]): Field = Field(input.map(HydrothermalVent.fromString).toList)
  }

  val field = Field.fromString(source)

  println(s"overlaps=${field.overlaps}")

}
