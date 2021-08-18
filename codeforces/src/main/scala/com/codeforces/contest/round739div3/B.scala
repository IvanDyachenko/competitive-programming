package com.codeforces.contest.round739div3

/** B. Who's Opposite?
  * https://codeforces.com/contest/1560/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(a, b, c) = readLine().split(" ").map(_.toInt)

    val l = math.abs(a - b)
    val n = 2 * l
    val d = Option.when((a max b max c) <= n)(if (c <= l) c + l else c - l)

    println(d.getOrElse(-1))
  }
}
