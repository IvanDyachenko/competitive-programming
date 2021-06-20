package com.codeforces.contest.round95edu

/** B. Negative Prefixes
  * - https://codeforces.com/contest/1418/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)
    val ln = readLine().split(" ").map(_.toInt)

    val bn = (an zip ln).collect { case (a, 0) => a }.sorted
    val cn = (an zip ln)
      .foldRight((List.empty[Int], 0)) {
        case ((a, 1), (ck, i)) => (a :: ck, i)
        case ((_, 0), (ck, i)) => (bn(i) :: ck, i + 1)
      }
      ._1

    println(cn.mkString(" "))
  }
}
