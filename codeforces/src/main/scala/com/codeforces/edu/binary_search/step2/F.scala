package com.codeforces.edu.binary_search.step2

import scala.collection.Searching.SearchResult
import scala.collection.Searching.InsertionPoint

/** F. String Game
  * - https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/F
  */
object F extends App {
  import scala.io.StdIn._

  val t  = readLine()
  val p  = readLine()
  val at = readLine().split(" ").map(_.toInt - 1)

  def f(n: Int): Boolean = {
    val excluded = at.take(n).sorted

    @annotation.tailrec
    def go(i: Int, j: Int, e: Int): Boolean =
      if (j == p.length) true
      else if (i == t.length) false
      else if (e < excluded.length && i == excluded(e)) go(i + 1, j, e + 1)
      else if (t(i) == p(j)) go(i + 1, j + 1, e)
      else go(i + 1, j, e)

    go(0, 0, 0)
  }

  @annotation.tailrec
  def binarySearch(left: Int, right: Int): Int =
    if (left + 1 >= right) left
    else {
      val mid = (left + right) / 2

      f(mid) match {
        case true => binarySearch(mid, right)
        case _    => binarySearch(left, mid)
      }
    }

  val ans = binarySearch(0, t.length)

  println(ans)
}
