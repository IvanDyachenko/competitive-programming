package com.codeforces.edu.binary_search.step2

/** A. Packing Rectangles
  * - https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val Array(w, h, n) = readLine().split(" ").map(_.toLong)

  @annotation.tailrec
  def binarySearch(l: Long, r: Long, f: Long => Boolean): Long =
    if (l + 1 >= r) r
    else {
      val m = (r + l) / 2

      f(m) match {
        case true => binarySearch(l, m, f)
        case _    => binarySearch(m, r, f)
      }
    }

  def f: Long => Boolean =
    x => (x / w) * (x / h) >= n

  val r = {
    @annotation.tailrec
    def go(i: Long): Long =
      if (f(1L << i)) 1L << i
      else go(i + 1)

    go(0)
  }

  val ans = binarySearch(0, r, f)

  println(ans)
}
