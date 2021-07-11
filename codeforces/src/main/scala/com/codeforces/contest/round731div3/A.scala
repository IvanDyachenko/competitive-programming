package com.codeforces.contest.round731div3

/** A. Shortest Path with Obstacle
  * https://codeforces.com/contest/1547/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    readLine()
    val Array(xa, ya) = readLine().split(" ").map(_.toInt)
    val Array(xb, yb) = readLine().split(" ").map(_.toInt)
    val Array(xf, yf) = readLine().split(" ").map(_.toInt)

    val (xl, xr) = (xa min xb, xa max xb)
    val (yl, yr) = (ya min yb, ya max yb)

    val bypass =
      if (
        xl == xr && xl == xf && yl < yf && yf < yr ||
        yl == yr && yl == yf && xl < xf && xf < xr
      ) 2
      else 0

    val ans = xr - xl + yr - yl + bypass

    println(ans)
  }
}
