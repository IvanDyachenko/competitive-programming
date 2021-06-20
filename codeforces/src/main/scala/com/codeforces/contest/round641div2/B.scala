package com.codeforces.round641div2

/** B. Orac and Models
  * - https://codeforces.com/contest/1350/problem/B
  */
object B extends App {

  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val n  = scala.io.StdIn.readInt()
    val sn = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    var fn = Array.fill(n)(1)

    for {
      j <- 1 to n
      i <- j.to(n, j) if sn(j - 1) < sn(i - 1) && fn(i - 1) < fn(j - 1) + 1
    } fn(i - 1) = fn(j - 1) + 1

    val f = fn.max

    println(f)
  }
}
