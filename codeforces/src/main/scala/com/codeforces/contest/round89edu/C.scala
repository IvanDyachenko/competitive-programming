package com.codeforces.round89edu

/** C. Palindromic Paths
  * - https://codeforces.com/contest/1366
  */
object C extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, m) = readLine().split(" ").map(_.toInt)

    var a = Array.ofDim[Array[Int]](n)
    (0 until n).foreach(a(_) = readLine().split(" ").map(_.toInt))

    var b = Array.fill((n + m) / 2)(Array(0, 0))
    for {
      i <- 1 to n
      j <- 1 to m
      k  = i + j - 2
      d  = k min (n + m - 2 - k)
    } b(d)(a(i - 1)(j - 1)) += 1

    val ans = b.take((n + m - 1) / 2).foldLeft(0)((a, t) => a + t.min)

    println(ans)
  }
}
