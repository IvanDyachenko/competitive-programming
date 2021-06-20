package com.codeforces.edu.binary_search.step2

/** B. Ropes
  * - https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val Array(n, k) = readLine().split(" ").map(_.toInt)
  val an          = Array.fill(n)(readInt())

  def binarySearch(l: Double, r: Double, f: Double => Boolean): Double = {
    @annotation.tailrec
    def go(l: Double, r: Double, iter: Int): Double =
      if (iter > 100) l
      else {
        val m = (l + r) / 2

        f(m) match {
          case true => go(m, r, iter + 1)
          case _    => go(l, m, iter + 1)
        }
      }

    go(l, r, 0)
  }

  def f: Double => Boolean =
    x => an.foldLeft(0)((count, a) => count + (a / x).toInt) >= k

  val ans = binarySearch(0, 100000000, f)

  println(ans)
}
