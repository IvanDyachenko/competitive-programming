package com.codeforces.round640div4

/** B. Same Parity Summands
  * - https://codeforces.com/contest/1352/problem/B
  */
object B extends App {

  private def summands(n: Int, k: Int): List[List[Int]] =
    List(1, 2)
      .map(r => (r, n - r * (k - 1)))
      .collect {
        case (r, d) if d > 0 && d % 2 == r % 2 => d :: List.fill(k - 1)(r)
      }

  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(n, k) = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    val ak = summands(n, k)

    if (ak.isEmpty) println("NO")
    else {
      println("YES")
      println(ak.head.mkString(" "))
    }
  }
}
