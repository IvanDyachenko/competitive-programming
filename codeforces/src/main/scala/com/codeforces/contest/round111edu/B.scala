package com.codeforces.contest.round111edu

/** B. Maximum Cost Deletion
  * https://codeforces.com/contest/1550/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, a, b) = readLine().split(" ").map(_.toInt)
    val s              = readLine()

    val ans =
      if (b >= 0) n * (a + b)
      else {
        val (c, _) = s.tail.foldLeft((1, s.head)) {
          case (state @ (_, p), c) if p == c => state
          case ((m, _), c)                   => (m + 1, c)
        }
        n * a + (c / 2 + 1) * b
      }

    println(ans)
  }
}
