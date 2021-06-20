package com.codeforces.round639div2

/** A. Puzzle Pieces
  * - https://codeforces.com/contest/1345/problem/A
  */
object A extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(n, m) = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    if ((m min n) == 1 || n == m && n == 2) println("YES")
    else println("NO")
  }
}
