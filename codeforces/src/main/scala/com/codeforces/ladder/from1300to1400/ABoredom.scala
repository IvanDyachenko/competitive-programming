package com.codeforces.ladder.from1300to1400

/** A. Boredom
  * https://codeforces.com/problemset/problem/455/A
  */
object ABoredom extends App {
  import scala.io.StdIn._

  val n  = readInt()
  val an = readLine().split(" ").map(_.toInt)

  val ans = {
    val counts = an.groupBy(identity).mapValues[Long](_.length)

    (2 to an.max)
      .foldLeft((0L, counts.getOrElse(1, 0L))) { case ((faimin2, faimin1), ai) =>
        (faimin1, faimin1 max (counts.getOrElse(ai, 0L) * ai + faimin2))
      }
      ._2
  }

  println(ans)
}
