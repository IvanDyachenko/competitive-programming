package com.codeforces.round637div2

/** A. Nastya and Rice
  * - https://codeforces.com/contest/1341/problem/A
  */
object A extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(n, a, b, c, d) = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    val l = n * (a - b)
    val r = n * (a + b)

    if (r >= c - d && l <= c + d) println("YES")
    else println("NO")
  }
}
