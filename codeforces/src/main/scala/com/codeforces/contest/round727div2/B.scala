package com.codeforces.contest.round727div2

/** B. Love Song
  * https://codeforces.com/contest/1539/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val Array(n, q) = readLine().split(" ").map(_.toInt)
  val s           = readLine()
  val ps          = s.scanLeft(0L) { case (p, c) => p + c - 'a' + 1 }
  (0 until q).foreach { _ =>
    val Array(l, r) = readLine().split(" ").map(_.toInt)

    val ans = ps(r) - ps(l - 1)

    println(ans)
  }
}
