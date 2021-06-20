package com.codeforces.edu.binary_search.step2

/** E. Equation
  * - https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/E
  */
object E extends App {
  import scala.io.StdIn._

  val eps = 1e-6
  val c   = readDouble()

  def f(x: Double): Int = (x * x + math.sqrt(x) - c).signum

  def binarySearch(left: Double, right: Double, iter: Int): Double =
    if ((left - right).abs <= eps || iter > 60) right
    else {
      val midpoint = (left + right) / 2

      f(midpoint) match {
        case 0  => midpoint
        case -1 => binarySearch(midpoint, right, iter + 1)
        case 1  => binarySearch(left, midpoint, iter + 1)
      }
    }

  def overhead = {
    @annotation.tailrec
    def go(x: Long): Long = f(x) match {
      case -1 | 0 => go(x << 1)
      case 1      => x
    }
    go(1)
  }

  val ans = binarySearch(0, overhead, 0)

  println(ans)
}
