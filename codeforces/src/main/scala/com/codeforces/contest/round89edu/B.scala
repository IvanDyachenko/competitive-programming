package com.codeforces.round89edu

/** B. Shuffle
  * - https://codeforces.com/contest/1366/problem/B
  */
object B extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(n, x, m) = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    val (l, r) = (0 until m).foldLeft((x, x)) { case ((l, r), i) =>
      val Array(li, ri) = scala.io.StdIn.readLine().split(" ").map(_.toInt)

      if (l <= ri && r >= li) (l min li, r max ri)
      else (l, r)
    }

    val ans = r - l + 1

    println(ans)
  }
}
