package com.codeforces.edu.binary_search.step2

/** C. Very Easy Task
  * - https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  @annotation.tailrec
  def binarySearch(left: Int, right: Int, f: Int => Boolean): Int =
    if (left + 1 >= right) right
    else {
      val midpoint = (left + right) / 2

      f(midpoint) match {
        case true => binarySearch(left, midpoint, f)
        case _    => binarySearch(midpoint, right, f)
      }
    }

  val Array(n, x, y) = readLine().split(" ").map(_.toInt)
  val (z, w)         = (x min y, x max y)

  val f: Int => Boolean = t => t / z + (t - z).abs / w >= n

  val reserve = {
    @annotation.tailrec
    def go(iter: Int): Int = if (f(iter)) iter else go(iter << 1)

    go(1)
  }

  val ans = binarySearch(0, reserve, f)

  println(ans)
}
