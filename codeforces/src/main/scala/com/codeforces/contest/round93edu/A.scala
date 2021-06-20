package com.codeforces.round93edu

/** A. Bad Triangle
  * - https://codeforces.com/contest/1398/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    if (an(0) + an(1) > an.last) println("-1")
    else println(s"1 2 $n")
  }
}
