package com.codeforces.edu.binary_search.step3

/** B. Splitting an Array
  * - https://codeforces.com/edu/course/2/lesson/6/3/practice/contest/285083/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val Array(n, k) = readLine().split(" ").map(_.toInt)
  val an          = readLine().split(" ").map(_.toInt)

  def f(s: Long): Boolean = {
    val (c, _) = an.foldLeft((0L, s)) {
      case ((c, r), a) if a <= r => (c, r - a)
      case ((c, r), a) if a <= s => (c + 1, s - a)
      case ((c, _), _)           => (c + k, s)
    }

    c < k
  }

  @annotation.tailrec
  def binarySearch(from: Long, to: Long): Long =
    if (from + 1 >= to) to
    else {
      val mid = (from + to) / 2

      f(mid) match {
        case true => binarySearch(from, mid)
        case _    => binarySearch(mid, to)
      }
    }

  val s = an.foldLeft(0L)(_ + _)

  val ans = binarySearch(0, s)

  println(ans)
}
