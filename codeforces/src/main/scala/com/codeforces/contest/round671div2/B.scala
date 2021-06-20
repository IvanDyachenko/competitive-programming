package com.codeforces.contest.round671div2

/** B. Stairs
  * - https://codeforces.com/contest/1419/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val x = readLong()

    @annotation.tailrec
    def go(x: Long, n: Long, count: Int): Int = {
      val req = n * (n + 1) / 2

      if (x - req >= 0) go(x - req, n + n + 1, count + 1)
      else count
    }

    val ans = go(x, 1, 0)

    println(ans)
  }
}
