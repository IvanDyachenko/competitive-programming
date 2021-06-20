package com.codeforces.contest.round668div2

/** B. Array Cancellation
  * - https://codeforces.com/contest/1405/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    val ans = an
      .foldRight((0L, 0L)) { case (el, (subSum, partSum)) =>
        (subSum max (partSum + el), partSum + el)
      }
      ._1

    println(ans)
  }
}
