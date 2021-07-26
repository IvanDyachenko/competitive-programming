package com.codeforces.contest.round15global

/** A. Subsequence Permutation
  * https://codeforces.com/contest/1552/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n = readInt()
    val s = readLine()

    val k = (s zip s.sorted).count { case (a, b) => a != b }

    println(k)
  }
}
