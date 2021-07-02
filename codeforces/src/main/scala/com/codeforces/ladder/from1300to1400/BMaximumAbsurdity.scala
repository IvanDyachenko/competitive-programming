package com.codeforces.ladder.from1300to1400

/** B. Maximum Absurdity
  * https://codeforces.com/problemset/problem/332/B
  */
object BMaximumAbsurdity extends App {
  import scala.io.StdIn._

  val Array(n, k) = readLine().split(" ").map(_.toInt) // 2 <= n <= 200000, 0 < 2k <= n
  val xn          = readLine().split(" ").map(_.toInt) // 1 <= xi <= 10^9

  val ((a, b), _) = {
    val prefix: Array[Long]  = xn.scanLeft(0L)(_ + _)
    def absurd(i: Int): Long = prefix(i + k) - prefix(i)

    ((n - 2 * k - 1) to (0, -1)).foldLeft(((n - 2 * k, n - k), n - k)) { case (((a, b), d), c) =>
      val e = c + k

      val (aa, ab, ac, ad, ae) = (absurd(a), absurd(b), absurd(c), absurd(d), absurd(e))

      (
        if (ac + (ae max ad) >= aa + ab) (c, if (ae >= ad) e else d) else (a, b),
        if (ae >= ad) e else d
      )
    }
  }

  println(s"${a + 1} ${b + 1}")
}
