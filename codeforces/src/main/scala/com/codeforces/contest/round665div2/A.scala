package com.codeforces.round665div2

/** A. Distance and Axis
  * - https://codeforces.com/contest/1401/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, k) = readLine().split(" ").map(_.toInt)

    val ans =
      if (n <= k) k - n
      else (n % 2 - k % 2).abs

    println(ans)
  }
}
