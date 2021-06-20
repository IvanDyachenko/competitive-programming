package com.codeforces.round641div2

/** D. Orac and Medians
  * - https://codeforces.com/contest/1350/problem/D
  * - https://codeforces.com/blog/entry/77284
  */
object D extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val an          = readLine().split(" ").map(_.toInt)

    val ans =
      an.contains(k) && an.sliding(3).exists {
        case Array(x, y, z) => x >= k && y <= k && z >= k || x >= k && y >= k || y >= k && z >= k
        case Array(x, y)    => x == k && y >= k || y == k && x >= k
        case Array(_)       => true
      }

    if (ans) println("yes")
    else println("no")
  }
}
