package com.codeforces.round644div3

/** C. Similar Pairs
  * - https://codeforces.com/contest/1360/problem/C
  */
object C extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val n  = scala.io.StdIn.readInt()
    val an = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList

    val (al, ar) = an.partition(_ % 2 == 0)

    val ans = al.length % 2 == 0 || al.exists(l => ar.exists(r => 1 == (l - r).abs))

    if (ans) println("YES")
    else println("NO")
  }
}
