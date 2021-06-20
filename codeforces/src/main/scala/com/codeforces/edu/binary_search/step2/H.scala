package com.codeforces.edu.binary_search.step2

/** H. Hamburgers
  * - https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/H
  */
object H extends App {
  import scala.io.StdIn._

  val (rb, rs, rc) = readLine().foldLeft((0L, 0L, 0L)) {
    case ((b, s, c), 'B') => (b + 1, s, c)
    case ((b, s, c), 'S') => (b, s + 1, c)
    case ((b, s, c), 'C') => (b, s, c + 1)
    case (recipe, _)      => recipe
  }

  val Array(nb, ns, nc) = readLine().split(" ").map(_.toLong)
  val Array(pb, ps, pc) = readLine().split(" ").map(_.toLong)
  val p                 = readLong()

  def f(x: Long): Boolean =
    (x * rb - nb).max(0) * pb + (x * rs - ns).max(0) * ps + (x * rc - nc).max(0) * pc <= p

  @annotation.tailrec
  def binarySearch(from: Long, until: Long): Long =
    if (from + 1 >= until) from
    else {
      val mid = (from + until) / 2

      f(mid) match {
        case true => binarySearch(mid, until)
        case _    => binarySearch(from, mid)
      }
    }

  val dream = {
    @annotation.tailrec
    def go(x: Long): Long = if (f(x)) go(x << 1) else x
    go(1)
  }

  val ans = binarySearch(0, dream)

  println(ans)
}
