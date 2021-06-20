package com.codeforces.contest.round96edu

/** A. Number of Apartments
  * - https://codeforces.com/contest/1430/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  (0 until readInt()).foreach { _ =>
    val n = readInt()

    val (i, j, k) = n % 3 match {
      case 0 => (n / 3, 0, 0)
      case 1 => (n / 3 - 2, 0, 1) // n = 3 * i + 1 = 3 * (i - 2) + 7
      case 2 => (n / 3 - 1, 1, 0) // n = 3 * i + 2 = 3 * (i - 1) + 5
    }

    if (i < 0) println(-1)
    else println(s"$i $j $k")
  }
}
