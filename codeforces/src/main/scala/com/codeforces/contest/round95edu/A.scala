package com.codeforces.contest.round95edu

/** A. Buying Torches
  * - https://codeforces.com/contest/1418/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(x, y, k) = readLine().split(" ").map(_.toLong)

    val ans = 1 + k + (k * (y + 1) - 2) / (x - 1)

    println(ans)
  }
}
