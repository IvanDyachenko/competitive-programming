package com.codeforces.contest.round668div2

/** A. Permutation Forgery
  * - https://codeforces.com/contest/1405/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val pn = readLine().split(" ").map(_.toInt)

    val ans = pn.reverse

    println(ans.mkString(" "))
  }
}
