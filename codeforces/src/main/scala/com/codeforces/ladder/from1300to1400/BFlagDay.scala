package com.codeforces.ladder.from1300to1400

/** B. Flag Day
  * https://codeforces.com/problemset/problem/357/B
  */
object BFlagDay extends App {
  import scala.io.StdIn._

  val Array(n, m) = readLine().split(" ").map(_.toInt)
  val dances      = Array.fill(m)(readLine().split(" ").map(_.toInt))

  val ans = {
    val clothes = Array.fill(n + 1)(0)

    dances.foreach { dancers =>
      val unfree = dancers.collect { case dancer if clothes(dancer) != 0 => clothes(dancer) }
      val free   = Array(1, 2, 3) diff unfree

      val naked = dancers.collect { case dancer if clothes(dancer) == 0 => dancer }

      naked.foldLeft(0) { case (i, dancer) =>
        clothes(dancer) = free(i)
        i + 1
      }
    }

    clothes.tail
  }

  println(ans.mkString(" "))
}
