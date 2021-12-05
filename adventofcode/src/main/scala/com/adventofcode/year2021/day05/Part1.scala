package com.adventofcode.year2021.day05

/** Day 5. Hydrothermal Venture. Part 1
  * https://adventofcode.com/2021/day/5
  */
object Part1 extends App {
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
      val data = Array.fill(1000)(Array.fill(1000)(0))
      vents.foreach {
        case HydrothermalVent((x1, y1), (x2, y2)) if x1 == x2 || y1 == y2 =>
          for {
            x <- (x1 min x2) to (x1 max x2)
            y <- (y1 min y2) to (y1 max y2)
          } data(x)(y) += 1
        case _                                                            =>
      }

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
