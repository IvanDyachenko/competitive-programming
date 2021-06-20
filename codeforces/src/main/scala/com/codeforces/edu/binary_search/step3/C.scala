package com.codeforces.edu.binary_search.step3

/** C. Cows in Stalls
  * - https://codeforces.com/edu/course/2/lesson/6/3/practice/contest/285083/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  val Array(n, k) = readLine().split(" ").map(_.toInt)
  val sn          = readLine().split(" ").map(_.toInt)

  def f(d: Int): Boolean = {

    @annotation.tailrec
    def go(count: Int, i: Int, j: Int): Boolean =
      if (j >= n) count >= k
      else {
        val e = sn(j) - sn(i)
        if (e >= d) go(count + 1, j, j + 1)
        else go(count, i, j + 1)
      }

    go(1, 0, 1)
  }

  @annotation.tailrec
  def binarySearch(left: Int, right: Int): Int =
    if (left + 1 >= right) left
    else {
      def mid = (left + right) / 2

      f(mid) match {
        case true => binarySearch(mid, right)
        case _    => binarySearch(left, mid)
      }
    }

  val ans = binarySearch(1, 1000000000)

  println(ans)
}
