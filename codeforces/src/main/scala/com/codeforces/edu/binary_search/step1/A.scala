package com.codeforces.edu.binary_search.step1

/** A. Binary Search
  * - https://codeforces.com/edu/course/2/lesson/6/1/practice/contest/283911/problem/A
  */
object A extends App {
  import scala.io.StdIn._
  import scala.collection.Searching.{Found, InsertionPoint, SearchResult}

  def binarySearch(seq: IndexedSeq[Int], elem: Int): SearchResult = {
    @annotation.tailrec
    def go(from: Int, to: Int): SearchResult =
      if (from > to) InsertionPoint(from)
      else {
        val midpoint = (from + to) / 2

        math.signum(elem compare seq(midpoint)) match {
          case 0  => Found(midpoint)
          case 1  => go(midpoint + 1, to)
          case -1 => go(from, midpoint - 1)
        }
      }

    go(0, seq.length - 1)
  }

  val Array(_, k) = readLine().split(" ").map(_.toInt)
  val seq         = readLine().split(" ").map(_.toInt)
  val queries     = readLine().split(" ").map(_.toInt)

  queries.foreach { elem =>
    val ans = binarySearch(seq, elem) match {
      case Found(_) => "YES"
      case _        => "NO"
    }

    println(ans)
  }
}
