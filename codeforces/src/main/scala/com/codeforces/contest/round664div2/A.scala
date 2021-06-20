package com.codeforces.round664div2

/** A. Boboniu Likes to Color Balls
  * - https://codeforces.com/contest/1395/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  private def check(r: Long, g: Long, b: Long, w: Long): Boolean =
    r >= 0 && g >= 0 && b >= 0 && List(r, g, b, w).foldLeft(0L)(_ + _ % 2) <= 1

  (0 until t).foreach { _ =>
    val Array(r, g, b, w) = readLine().split(" ").map(_.toLong)

    val ans = check(r, g, b, w) || check(r - 1, g - 1, b - 1, w + 3)

    if (ans) println("Yes") else println("No")
  }
}
