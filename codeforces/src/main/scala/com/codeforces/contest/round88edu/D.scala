package com.codeforces.round88edu

/** D. Yet Another Yet Another Task
  * - https://codeforces.com/contest/1359/problem/D
  */
object D extends App {
  val n  = scala.io.StdIn.readInt()
  val an = scala.io.StdIn.readLine().split(" ").map(_.toInt)

  val ans = (0 to 30).foldLeft(0) { case (ans, m) =>
    ans max (an
      .foldLeft((0, 0)) { case ((subSum, partSum), a) =>
        if (a > m) (subSum, 0)
        else (subSum max (partSum + a), 0 max (partSum + a))
      }
      ._1 - m)
  }

  println(ans)
}
