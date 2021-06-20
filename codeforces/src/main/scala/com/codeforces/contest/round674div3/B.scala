package com.codeforces.contest.round674div3

/** B. Symmetric Matrix
  * - https://codeforces.com/contest/1426/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, m) = readLine().split(" ").map(_.toInt)

    val tiles = (0 until n).foldLeft(0) { case (ts, _) =>
      val Array(_, a) = readLine().split(" ").map(_.toInt)
      val Array(b, _) = readLine().split(" ").map(_.toInt)

      if (a == b) ts + 1 else ts
    }

    val ans = if (m % 2 == 0 && tiles >= 1) "YES" else "NO"

    println(ans)
  }
}
