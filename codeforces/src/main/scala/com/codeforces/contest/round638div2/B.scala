package com.codeforces.round638div2

/** B. Phoenix and Beauty
  * - https://codeforces.com/contest/1348/problem/B
  */
object B extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(n, k) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val an          = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    val ad = an.distinct.toList
    val d  = ad.length

    if (d > k) println(-1)
    else {
      val sub                    = ad ::: (1 to k).toList.diff(ad).take(k - d)
      lazy val subs: Stream[Int] = sub.toStream #::: subs

      val ans = subs.take(k * n).toList

      println(ans.length)
      println(ans.mkString(" "))
    }
  }
}
