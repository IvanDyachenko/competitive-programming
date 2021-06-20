package com.codeforces.round642div3

/** B. Two Arrays And Swaps
  * - https://codeforces.com/contest/1353/problem/B
  */
object B extends App {

  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(n, k) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val (ak, ar)    = scala.io.StdIn.readLine().split(" ").map(_.toInt).sorted.splitAt(k)
    val bk          = scala.io.StdIn.readLine().split(" ").map(_.toInt).sorted(Ordering.Int.reverse).take(k)

    val ans = ar.sum + (bk ++ ak).sorted(Ordering.Int.reverse).take(k).sum

    println(ans)
  }
}
