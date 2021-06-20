package com.codeforces.edu.binary_search.step2

/** D. Children Holiday
  * - https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/D
  */
object D extends App {
  import scala.io.StdIn._

  val Array(m, n) = readLine().split(" ").map(_.toInt)
  val skills      = Array.fill(n) {
    val Array(t, z, y) = readLine().split(" ").map(_.toInt)
    (t, y, z)
  }

  def f: Int => Boolean =
    t =>
      skills.foldLeft(0) { case (ballons, (ti, yi, zi)) =>
        val cycle                 = ti * zi + yi
        val (quotient, remainder) = (t / cycle, (t % cycle / ti) min zi)
        val count                 = quotient * zi + remainder

        ballons + count
      } >= m

  def reserve = {
    @annotation.tailrec
    def go(time: Int): Int = if (f(time)) time else go(time << 1)
    go(1)
  }

  def binarySearch(left: Int, right: Int): Int =
    if (left + 1 >= right) right
    else {
      val midpoint = (left + right) / 2

      f(midpoint) match {
        case true => binarySearch(left, midpoint)
        case _    => binarySearch(midpoint, right)
      }
    }

  val ans =
    if (m == 0) 0
    else binarySearch(0, reserve)

  println(ans)
  skills.foldLeft(m) { case (m, (ti, yi, zi)) =>
    val cycle                 = ti * zi + yi
    val (quotient, remainder) = (ans / cycle, (ans % cycle / ti) min zi)
    val count                 = (quotient * zi + remainder) min m

    print(s"$count ")

    m - count
  }
  println()
}
