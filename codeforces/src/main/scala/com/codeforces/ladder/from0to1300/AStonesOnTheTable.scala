package com.codeforces.ladder.from0to1300

/** A. Stones on the Table
  * - https://codeforces.com/problemset/problem/266/A
  */
object AStonesOnTheTable extends App {
  import scala.io.StdIn._

  val n = readInt()
  val s = readLine()

  val ans = s.tail
    .foldLeft((0, s.head)) { case ((stones, prev), curr) =>
      (stones + (if (prev == curr) 1 else 0), curr)
    }
    ._1

  println(ans)
}
