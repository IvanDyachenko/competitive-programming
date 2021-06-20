package com.codeforces.round89edu

/** A. Shovels and Swords
  * - https://codeforces.com/contest/1366/problem/A
  */
object A extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(a, b) = scala.io.StdIn.readLine().split(" ").map(_.toInt).sorted

    /** a = 2 * t1 + t2 b = t1 + 2 * t2
      *
      * ans = t1 + t2 a <= ans b <= ans
      *
      * a + b = 3 * t1 + 3 * t2 t1 + t2 = (a + b) / 3
      *
      * ans = min(a, b, (a + b) / 3)
      */
    val ans = a min b min ((a + b) / 3)

    println(ans)
  }
}
