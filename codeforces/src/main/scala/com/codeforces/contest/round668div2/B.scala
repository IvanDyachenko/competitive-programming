package com.codeforces.contest.round668div2

/**
  * B. Array Cancellation
  * https://codeforces.com/contest/1405/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    val ans = an
      .foldLeft((0L, 0L)) {
        case ((damper, cost), a) =>
          if (a < 0) ((damper + a) max 0, cost + (damper + a).min(0))
          else (damper + a, cost)
      }
      ._1

    println(ans)
  }
}
