package com.codeforces.round644div3

/** B. Honest Coach
  * - https://codeforces.com/contest/1360/problem/B
  */
object B extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val n  = scala.io.StdIn.readInt()
    val sn = scala.io.StdIn.readLine().split(" ").map(_.toInt).sorted

    val ans = sn.zip(sn.tail).map { case (a, b) => b - a }.min

    println(ans)
  }
}
