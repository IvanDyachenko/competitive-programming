package com.codeforces.round633div2

/** B. Sorted Adjacent Differences
  * - https://codeforces.com/contest/1339/problem/B https://codeforces.com/blog/entry/75913
  */
object B extends App {

  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val n  = scala.io.StdIn.readInt()
    val m  = (n - 1) / 2
    val an = scala.io.StdIn.readLine().split(" ").map(_.toInt).sorted
    val bn = List(m, m + (n + 1) % 2).distinct.map(an) ::: (0 until m).foldLeft(List.empty[Int])((bn, i) =>
      an(i) :: an(n - i - 1) :: bn
    )

    println(bn.mkString(" "))
  }
}
