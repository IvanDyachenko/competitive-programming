package com.codeforces.round640div4

/** C. K-th Not Divisible by n
  * - https://codeforces.com/contest/1352/problem/C
  */
object C extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(n, k) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val ans         = k + (k - 1) / (n - 1)

    println(ans)
  }
}
