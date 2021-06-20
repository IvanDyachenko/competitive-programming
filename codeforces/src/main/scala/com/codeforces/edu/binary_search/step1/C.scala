package com.codeforces.edu.binary_search.step1

/** C. Closest to the Right
  * - https://codeforces.com/edu/course/2/lesson/6/1/practice/contest/283911/problem/C
  */
object C extends App {
  import scala.io.StdIn._
  import scala.collection.Searching.{Found, InsertionPoint, SearchResult}

  def closestToTheRight(seq: IndexedSeq[Int], elem: Int): SearchResult = {
    val n = seq.length

    @annotation.tailrec
    def go(from: Int, to: Int): SearchResult =
      if (from + 1 >= to)
        if (to == n) InsertionPoint(n)
        else if (elem == seq(to)) Found(to)
        else if (from == -1) InsertionPoint(0)
        else InsertionPoint(to)
      else {
        val midpoint = (from + to) / 2

        math.signum(elem compare seq(midpoint)) match {
          case 1      => go(midpoint, to)
          case 0 | -1 => go(from, midpoint)
        }
      }

    go(-1, n)
  }

  val Array(_, k) = readLine().split(" ").map(_.toInt)
  val seq         = readLine().split(" ").map(_.toInt)
  val queries     = readLine().split(" ").map(_.toInt)

  queries.foreach { elem =>
    val ans = closestToTheRight(seq, elem) match {
      case Found(i)          => i + 1
      case InsertionPoint(i) => i + 1
    }

    println(ans)
  }
}
