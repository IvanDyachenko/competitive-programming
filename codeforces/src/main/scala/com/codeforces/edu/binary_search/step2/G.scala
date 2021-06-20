package com.codeforces.edu.binary_search.step2

/** G. Student Councils
  * - https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/G
  */
object G extends App {
  import scala.io.StdIn._

  val k  = readInt()
  val n  = readInt()
  val an = Array.fill(n)(readLong())

  def f(c: Long): Boolean = {
    val (r, _) = an.foldLeft((0L, 0L)) { case ((r, t), a) =>
      (r + (t + a.min(c)) / c, (t + a.min(c)) % c)
    }
    r >= k
  }

  @annotation.tailrec
  def binarySearch(from: Long, until: Long): Long =
    if (from + 1 >= until) from
    else {
      val mid = (from + until) / 2L

      f(mid) match {
        case true => binarySearch(mid, until)
        case _    => binarySearch(from, mid)
      }
    }

  val until = {
    @annotation.tailrec
    def go(until: Long): Long = if (f(until)) go(until << 1) else until
    go(1L)
  }

  val ans = binarySearch(0L, until)

  println(ans)
}
