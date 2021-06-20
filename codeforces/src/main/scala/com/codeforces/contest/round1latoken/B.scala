package com.codeforces.contest.round1latoken

/** B. Histogram Ugliness
  * - https://codeforces.com/contest/1534/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    def ai(i: Int): Int = if (i < 0 || i > n - 1) 0 else an(i)

    val ans = (0 to n)
      .foldLeft((0L, 0)) {
        case ((s, _), i) if ai(i) > ai(i - 1) && ai(i) > ai(i + 1) =>
          val h = ai(i - 1) max ai(i + 1)
          val l = h - ai(i - 1)
          (s + ai(i) - h + l, h)
        case ((s, aj), i)                                          =>
          (s + Math.abs(ai(i) - aj), ai(i))
      }
      ._1

    println(ans)
  }
}
