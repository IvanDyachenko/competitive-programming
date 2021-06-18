package com.codeforces.contest.round726div2

/** B. Bad Boy
  * - https://codeforces.com/contest/1537/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, m, i, j) = readLine().split(" ").map(_.toInt)

    println(s"1 1 $n $m")
  }
}
