package com.codeforces.round90edu

/** A. Donut Shops
  * - https://codeforces.com/contest/1373/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(a, b, c) = readLine().split(" ").map(_.toLong)

    val (ans1, ans2) = (if (a < c) 1 else -1, if (a * b > c) b else -1)

    println(s"$ans1 $ans2")
  }
}
