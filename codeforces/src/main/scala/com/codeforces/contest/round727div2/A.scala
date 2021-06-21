package com.codeforces.contest.round727div2

/** A. Contest Start
  * - https://codeforces.com/contest/1539/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  /** Dissatisfaction equals to the number of participants that
    * started the contest (or starting it now), but haven't yet
    * finished it.
    *
    * @param n The number of participants
    * @param x The start interval
    * @param t The contest duration
    */
  private def dissatisfaction(n: Int, x: Int, t: Int): Long = {
    // 1. Рассмотрим все i такие, что i * x + t <= (n-1) * x
    //    i + t/x <= n - 1
    //    i <= n - 1 - t/x
    //    i принадлежит [1, n - 1 - t/x], а значит таких i ровно min(0, n - t/x)
    //    (i + m) * x <= i * x + t
    //    i + m <= i + t/x
    //    m <= t/x, а значит m принадлежит [1, t/x]
    //    В результате получим max(0, n - t/x) * t/x
    // 2. В случае, когда (n - 1) * x попадает в интервал [i * x, i * x + t]
    //    получаем, что m принимает значение n - 1 - i, т.е. 0, 1, 2, ..., (t/x - 1)
    //    В результате получим t/x * (t/x - 1) / 2
    val d = (t / x).toLong
    d * 0L.max(n - d) + d.min(n) * (d.min(n) - 1L) / 2L
  }

  val k = readInt()

  (0 until k).foreach { _ =>
    val Array(n, x, t) = readLine().split(" ").map(_.toInt)

    val ans = dissatisfaction(n, x, t)

    println(ans)
  }
}
