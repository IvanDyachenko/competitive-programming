package com.codeforces.round641div2

/** A. Orac and Factors
  * - https://codeforces.com/contest/1350/problem/A
  */
object A extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(n, k) = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    val r = n + 2 * 0.max(k - 1) + (2 #:: Stream.iterate(3)(_ + 2)).find(n % _ == 0).get

    println(r)
  }
}
