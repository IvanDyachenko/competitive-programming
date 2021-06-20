package com.codeforces.contest.round674div3

/** A. Floor Number
  * - https://codeforces.com/contest/1426/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, x) = readLine().split(" ").map(_.toInt)
    val ans         = 1 + 0.max(n + x - 3) / x

    println(ans)
  }
}
