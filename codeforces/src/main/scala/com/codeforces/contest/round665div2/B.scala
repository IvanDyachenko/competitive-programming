package com.codeforces.round665div2

/** B. Ternary Sequence
  * - https://codeforces.com/contest/1401/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(x1, y1, z1) = readLine().split(" ").map(_.toInt) // a: 0, 1, 2
    val Array(x2, y2, z2) = readLine().split(" ").map(_.toInt) // b: 0, 1, 2

    val (t1, t2) = (z1 min y2, z2 min x1)
    val t3       = (z1 - t1) min (z2 - t2)
    val t4       = y1 min (z2 - t2 - t3)

    val ans = 2L * (t1 - t4)

    println(ans)
  }
}
