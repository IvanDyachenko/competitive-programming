package com.codeforces.round88edu

/** A. Berland Poker
  * - https://codeforces.com/contest/1359/problem/A
  */
object A extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(n, m, k) = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    val t   = n / k
    val ans =
      if (t >= m) m
      else t - 1 - (m - t - 1) / (k - 1)

    println(ans)
  }
}
