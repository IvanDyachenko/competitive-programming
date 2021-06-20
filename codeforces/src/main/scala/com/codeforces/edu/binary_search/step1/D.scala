package com.codeforces.edu.binary_search.step1

/** D. Fast search
  * - https://codeforces.com/edu/course/2/lesson/6/1/practice/contest/283911/problem/D
  */
object D extends App {
  import scala.io.StdIn._

  val n  = readInt()
  val an = readLine().split(" ").map(_.toInt).sorted
  val k  = readInt()

  @annotation.tailrec
  def closestToTheLeft(elem: Int, from: Int, to: Int): Int =
    if (from + 1 >= to) n min from
    else {
      val midpoint = (from + to) / 2

      math.signum(elem compare an(midpoint)) match {
        case 0 | 1 => closestToTheLeft(elem, midpoint, to)
        case _     => closestToTheLeft(elem, from, midpoint)
      }
    }

  @annotation.tailrec
  def closestToTheRight(elem: Int, from: Int, to: Int): Int =
    if (from + 1 >= to) 0 max to
    else {
      val midpoint = (from + to) / 2

      math.signum(elem compare an(midpoint)) match {
        case -1 | 0 => closestToTheRight(elem, from, midpoint)
        case _      => closestToTheRight(elem, midpoint, to)
      }
    }

  def fastSearch(lower: Int, upper: Int): Int =
    closestToTheLeft(upper, -1, n) - closestToTheRight(lower, -1, n) + 1

  (0 until k).foreach { _ =>
    val Array(lower, upper) = readLine().split(" ").map(_.toInt)

    val ans = fastSearch(lower, upper)

    println(ans)
  }

}
