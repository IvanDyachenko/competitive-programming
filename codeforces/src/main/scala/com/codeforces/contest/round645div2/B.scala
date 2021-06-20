package com.codeforces.round645div2

/** B. Maria Breaks the Self-isolation
  * - https://codeforces.com/contest/1358/problem/B
  */
object B extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val n  = scala.io.StdIn.readInt()
    val an = scala.io.StdIn.readLine().split(" ").map(_.toInt).sorted

    val ans = an.zipWithIndex.foldLeft(1) { case (c, (a, i)) => if (a <= i + 1) i + 2 else c }

    println(ans)
  }
}
