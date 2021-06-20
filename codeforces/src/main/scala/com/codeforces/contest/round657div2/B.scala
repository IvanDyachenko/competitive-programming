package com.codeforces.round657div2

/** B. Dubious Cyrpto
  * - https://codeforces.com/contest/1379/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(l, r, m) = readLine().split(" ").map(_.toLong)

    val (p, q) = (m + l - r, m + r - l)

    (l to r).view.map(a => (q / a, a)).collectFirst {
      case (n, a) if n > 0 && n * a >= p && n * a <= q =>
        if (n * a - m < 0) (a, l + m - n * a, l)
        else (a, r + m - n * a, r)
    } match {
      case Some((a, b, c)) => println(s"$a $b $c")
      case None            => throw new Error("unexpeted exception")
    }
  }
}
