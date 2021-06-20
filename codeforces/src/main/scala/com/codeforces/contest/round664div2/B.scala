package com.codeforces.round664div2

/** B. Boboniu Plays Chess
  * - https://codeforces.com/contest/1395/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val Array(n, m, sx, sy) = readLine().split(" ").map(_.toInt)

  (0 until n).foldLeft((sx, sy)) { case ((x, y), i) =>
    val moves = (x, y) +: (1 to m).collect { case j if j != y => (x, j) }

    moves.foreach { case (x, y) => println(s"$x $y") }

    moves.last match {
      case (1, y) => (n, y)
      case (x, y) => (x - 1, y)
    }
  }
}
