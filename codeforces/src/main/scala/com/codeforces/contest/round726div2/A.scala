package com.codeforces.contest.round726div2

/** A. Arithmetic Array
  * - https://codeforces.com/contest/1537/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n    = readInt()
    val an   = readLine().split(" ").map(_.toInt)
    val asum = an.foldLeft(0L)(_ + _)

    val ans =
      if (n < asum) asum - n
      else if (n > asum) 1
      else 0

    println(ans)
  }
}
