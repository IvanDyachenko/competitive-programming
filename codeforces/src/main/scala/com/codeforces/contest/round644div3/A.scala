package com.codeforces.round644div3

/** A. Minimal Square
  * - https://codeforces.com/contest/1360/problem/A
  */
object A extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(a, b) = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    val c   = (2 * (a min b)) max (a max b)
    val ans = c * c

    println(ans)
  }
}
