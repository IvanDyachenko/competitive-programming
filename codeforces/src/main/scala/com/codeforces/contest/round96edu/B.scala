package com.codeforces.contest.round96edu

/** B. Barrels
  * - https://codeforces.com/contest/1430/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val an          = readLine().split(" ").map(_.toInt).sorted(Ordering.Int.reverse)

    val ans = an.take(k + 1).foldLeft(0L)(_ + _)

    println(ans)
  }
}
