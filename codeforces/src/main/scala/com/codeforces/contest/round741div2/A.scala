package com.codeforces.contest.round741div2

/** A. The Miracle and the Sleeper
  * https://codeforces.com/contest/1562/problem/A
  */
object A extends App {
  def remainder(from: Int, to: Int): Int = {
    val t = if (to % 2 == 0) 2 else 1
    val d = from max ((to + t) / 2)
    to % d
  }

  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(l, r) = readLine().split(" ").map(_.toInt)

    val ans = remainder(l, r)

    println(ans)
  }

}
