package com.codeforces.round656div3

/** B. Restore the Permutation by Merger
  * - https://codeforces.com/contest/1385/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n   = readInt()
    val a2n = readLine().split(" ").map(_.toInt)
    val an  = a2n.distinct

    println(an.mkString(" "))
  }
}
