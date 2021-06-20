package com.codeforces.round643div2

/** A. Sequence with Digits
  * - https://codeforces.com/contest/1355/problem/A
  */
object A extends App {
  private def an(a1: Long, n: Long): Long = {
    def go(a1: String, n: Long): String =
      if (a1.contains('0') || n == 1) a1
      else go((a1.toLong + (a1.min - 48) * (a1.max - 48)).toString(), n - 1)

    go(a1.toString, n).toLong
  }

  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(a1, k) = scala.io.StdIn.readLine().split(" ").map(_.toLong)

    val ai = an(a1, k)

    println(ai)
  }
}
