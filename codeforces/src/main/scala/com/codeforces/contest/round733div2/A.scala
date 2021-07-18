package com.codeforces.contest.round733div2

/** A. Binary Decimal
  * https://codeforces.com/contest/1530/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readLine().split("").map(_.toInt)

    val ans = n.max

    println(ans)
  }
}
