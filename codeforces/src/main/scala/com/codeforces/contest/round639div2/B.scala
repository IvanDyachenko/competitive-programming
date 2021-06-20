package com.codeforces.round639div2

/** B. Card Constructions
  * - https://codeforces.com/contest/1345/problem/B
  */
object B extends App {
  val t = scala.io.StdIn.readInt()

  private def height(n: Long): Int =
    (math.sqrt(24 * n + 1) - 1).toInt / 6

  private def cards(h: Int): Int =
    h * (3 * h + 1) / 2

  private def solve(n: Long, count: Int = 0): Int =
    if (n == 0) count
    else {
      val h = height(n)

      if (h == 0) count
      else solve(n - cards(h), count + 1)
    }

  (0 until t).foreach { _ =>
    val n = scala.io.StdIn.readLong()

    val ans = solve(n)

    println(ans)
  }
}
