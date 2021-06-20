package com.codeforces.round645div2

/** A. Park Lighting
  * - https://codeforces.com/contest/1358/problem/A
  */
object A extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(n, m) = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    val ans = (n * m + 1) / 2

    println(ans)
  }
}
