package com.codeforces.contest.round672div2

/** C1. Pokémon Army (easy version)
  * - https://codeforces.com/contest/1420/problem/C1
  */
object C1 extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, _) = readLine().split(" ").map(_.toInt)
    val an          = readLine().split(" ").map(_.toInt)

    val (ans1, ans2) = an.foldLeft((0L, 0L)) { case ((dp1, dp2), a) =>
      (dp1 max (dp2 - a), dp2 max (dp1 + a))
    }

    val ans = ans1 max ans2

    println(ans)
  }
}
