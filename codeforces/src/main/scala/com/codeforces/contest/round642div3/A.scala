package com.codeforces.round642div3

/** A. Most Unstable Array
  * - https://codeforces.com/contest/1353/problem/A
  */
object A extends App {

  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(n, m) = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    val ans = 2.min(n - 1) * m

    println(ans)
  }
}
