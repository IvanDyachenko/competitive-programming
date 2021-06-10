package com.codeforces.contest.round725div3

/** A. Stone Game
  * - https://codeforces.com/contest/1538/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    val (s, b) = (1 until n).foldLeft((0, 0)) {
      case ((s, b), i) if an(i) < an(s) => (i, b)
      case ((s, b), i) if an(i) > an(b) => (s, i)
      case (c, _)                       => c
    }

    val ans = ((s + 1) max (b + 1)) min ((n - s) max (n - b)) min ((s + 1) + (n - b)) min ((n - s) + (b + 1))

    println(ans)
  }
}
