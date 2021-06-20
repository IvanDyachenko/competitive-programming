package com.codeforces.edu.binary_search.step1

/** B. Closest to the Left
  * - https://codeforces.com/edu/course/2/lesson/6/1/practice/contest/283911/problem/B
  */
object B extends App {
  import scala.io.StdIn._
  import scala.collection.Searching.{Found, InsertionPoint, SearchResult}

  def closestToTheLeft(seq: IndexedSeq[Int], elem: Int): SearchResult = {
    val n = seq.length

    @annotation.tailrec
    def go(from: Int, to: Int): SearchResult =
      if (from + 1 >= to)
        if (from == -1) InsertionPoint(from)
        else if (elem == seq(from)) Found(from)
        else if (to == n) InsertionPoint(n - 1)
        else InsertionPoint(from)
      else {
        val midpoint = (from + to) / 2

        math.signum(elem compare seq(midpoint)) match {
          case 0 | 1 => go(midpoint, to)
          case -1    => go(from, midpoint)
        }
      }

    go(-1, n)
  }

  val Array(_, k) = readLine().split(" ").map(_.toInt)
  val seq         = readLine().split(" ").map(_.toInt)
  val queries     = readLine().split(" ").map(_.toInt)

  queries.foreach { elem =>
    val ans = closestToTheLeft(seq, elem) match {
      case Found(i)          => i + 1
      case InsertionPoint(i) => i + 1
    }

    println(ans)
  }
}
