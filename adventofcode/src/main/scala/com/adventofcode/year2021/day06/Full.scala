package com.adventofcode.year2021.day06

/** Day 6. Lanternfish
  * https://adventofcode.com/2021/day/6
  */
object Full extends App {
  val source = scala.io.Source.fromResource("year2021/day06/input.txt").getLines().mkString("")

  final case class Shoal private[Shoal] (timer2fishes: Array[Long]) {
    def count: Long = timer2fishes.foldLeft(0L)(_ + _)

    def wait(days: Int): Shoal =
      if (days == 0) this
      else {
        Shoal {
          val next = Array.fill(10)(0L)
          timer2fishes.zipWithIndex.foreach {
            case (count, 0)     =>
              next(6) += count
              next(8) += count
            case (count, timer) =>
              next(timer - 1) += count
          }
          next
        } wait (days - 1)
      }
  }

  object Shoal {
    def apply(timers: List[Int]): Shoal = Shoal {
      val timer2fishes = Array.fill(10)(0L)
      timers.foreach(timer2fishes(_) += 1)
      timer2fishes
    }

    def fromString(input: String): Shoal = Shoal(input.split(",").map(_.toInt).toList)
  }

  val shoal = Shoal.fromString(source)

  println(s"How many lanternfish would there be after  80 days? ${shoal.wait(80).count}")
  println(s"How many lanternfish would there be after 256 days? ${shoal.wait(256).count}")
}
