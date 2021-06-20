package com.codeforces.round645div2

/** C. Celex Update
  * - https://codeforces.com/contest/1358/problem/C
  */
object C extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(x1, y1, x2, y2) = scala.io.StdIn.readLine().split(" ").map(_.toLong)

    val ans = (x2 - x1) * (y2 - y1) + 1

    println(ans)
  }
}
