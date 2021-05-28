package com.codeforces.contest.round723div2

/** A. Mean Inequality
  *   - https://codeforces.com/contest/1526/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n   = readInt()
    val a2n = readLine().split(" ").map(_.toInt).sorted
    val b2n = (0 until (2 * n)).map {
      case i if i % 2 == 0 => a2n(i / 2)
      case i => a2n(n + (i - 1) / 2)
    }

    println(b2n.mkString(" "))
  }
}
