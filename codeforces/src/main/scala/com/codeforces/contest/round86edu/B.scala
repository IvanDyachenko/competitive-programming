package com.codeforces.round86edu

/** B. Binary Period
  * - https://codeforces.com/contest/1342/problem/B
  */
object B extends App {
  val n = scala.io.StdIn.readInt()

  (0 until n).foreach { _ =>
    val t = scala.io.StdIn.readLine()

    val s =
      if (t.forall(_ == t.head)) t
      else "01" * t.length

    println(s)
  }
}
