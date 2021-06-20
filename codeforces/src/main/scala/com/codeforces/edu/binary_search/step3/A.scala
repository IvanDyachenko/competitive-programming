package com.codeforces.edu.binary_search.step3

/** A. Get together
  * - https://codeforces.com/edu/course/2/lesson/6/3/practice/contest/285083/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val eps = 1e-6
  val n   = readInt()
  val xvn = Array.fill(n) {
    val Array(x, v) = readLine().split(" ").map(_.toInt)
    x -> v
  }

  def f(t: Double): Boolean = {
    val (l, r) = xvn.foldLeft((Double.MinValue, Double.MaxValue)) { case ((l, r), (x, v)) =>
      (l max (x - t * v), r min (x + t * v))
    }
    l <= r
  }

  @annotation.tailrec
  def binarySearch(from: Double, to: Double, iter: Int = 0): Double =
    if (iter > 50 || (from + to).abs < eps) to
    else {
      val mid = (from + to) / 2

      f(mid) match {
        case true => binarySearch(from, mid, iter + 1)
        case _    => binarySearch(mid, to, iter + 1)
      }
    }

  val t = {
    @annotation.tailrec
    def go(t: Int): Int = if (f(t)) t else go(t << 1)
    go(1)
  }

  val ans = binarySearch(0, t)

  println(ans)
}
