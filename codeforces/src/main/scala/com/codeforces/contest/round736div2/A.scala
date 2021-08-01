package com.codeforces.contest.round736div2

/** A. Gregor and Cryptography
  * https://codeforces.com/contest/1549/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val p = readInt()

    val (a, b) = (2, p - 1)

    println(s"$a $b")
  }
}
