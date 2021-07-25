package com.codeforces.contest.round734div3

/** A. Polycarp and Coins
  * https://codeforces.com/contest/1551/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n        = readInt()
    val (d, r)   = (n / 3, n % 3)
    val (c1, c2) = (d + (if (r == 1) 1 else 0), d + (if (r == 2) 1 else 0))

    println(s"$c1 $c2")
  }
}
