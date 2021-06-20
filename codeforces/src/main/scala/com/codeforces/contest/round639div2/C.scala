package com.codeforces.round639div2

/** C. Hilbert's Hotel
  * - https://codeforces.com/contest/1345/problem/C
  */
object C extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val n  = scala.io.StdIn.readInt()
    val an = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    val bm = an.zipWithIndex.map { case (a, i) => (n + (a + i) % n) % n }.distinct

    if (n == bm.length) println("YES")
    else println("NO")
  }
}
